package com.hstc.studentoauserserver.controller;

import com.google.gson.Gson;
import com.hstc.studentoauserserver.converter.UserForm2UserConverter;
import com.hstc.studentoauserserver.enums.UserEnum;
import com.hstc.studentoauserserver.exception.UserException;
import com.hstc.studentoauserserver.form.UserForm;
import com.hstc.studentoauserserver.pojo.User;
import com.hstc.studentoauserserver.service.UserService;
import com.hstc.studentoauserserver.util.ResultVOUtil;

import com.hstc.studentoauserserver.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${spring.mail.username}")
    private String sender;

    public static Map<String, User> map = new HashMap<String, User>();

    @PostMapping("/login")
    public String Login(@RequestParam("email") String email, @RequestParam("password") String password,
                        HttpServletRequest request, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");             //设置请求头，使浏览器能跨域得到数据
        User user = userService.selectUserByEmail(email);
        if(user == null) return new Gson().toJson(ResultVOUtil.error(9999, "邮箱未被注册"));
        else if(user.getStatus() == UserEnum.INACTIVATED.getCode())
            return new Gson().toJson(ResultVOUtil.error(9999, "邮箱未被激活"));
        else if(user.getPassword().equals(password)){
//            stringRedisTemplate.opsForValue().set(user.getEmail(), user.getId());
            //TODO 使用quart定时检查用户token是否过时，过时则remove掉redis里面的用户对应
            String token = TokenUtil.genetateToken();
            HttpSession session = request.getSession();
            session.setAttribute(user.getEmail(), token);
            log.error("登陆成功");
            return new Gson().toJson(ResultVOUtil.success(token));
        }
        else {
            log.error("密码不正确");
            return new Gson().toJson(ResultVOUtil.error(9999, "密码不正确"));
        }
    }

    //注册功能
    @PostMapping("/register")
    public String registerUser(@Valid UserForm userForm, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()){
            log.error("用户注册信息不正确");
            throw new UserException(UserEnum.PARAM_ERRER.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        response.setHeader("Access-Control-Allow-Origin", "*");

        User user = UserForm2UserConverter.convert(userForm);

        //保存用户
        User result = userService.saveUser(user);

        //将没有激活的用户存进去map中
        if (map.get(result.getId()) == null)
            map.put(result.getId(), result);

        //发送验证邮件
        sendTemplateMail(result.getEmail(), result.getId());
        return new Gson().toJson(ResultVOUtil.success());
    }
    //激活账号
    @GetMapping("/activation/{id}")
    public String activation(@PathVariable String id) throws Exception{
        
        User user = map.get(id);
        if(user != null){
            user.setStatus(UserEnum.ACTIVATED.getCode());
            userService.saveUser(user);
            //将激活的用户移出map
            map.remove(user.getId());
        }
        return new Gson().toJson(ResultVOUtil.success());
    }

    @PostMapping("/forget")
    public String forget(@RequestParam("email") String email, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user = userService.selectUserByEmail(email);
        if (user == null) return new Gson().toJson(ResultVOUtil.error(9999, "邮箱未被注册"));
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        String repassword = String.valueOf(number);
        user.setPassword(repassword);
        User result = userService.updateUser(user);
        if(result == null) return new Gson().toJson(ResultVOUtil.error(9999, "重置不成功"));
        sendSimpleEmail(user.getEmail(), "您好，您的密码已经重置，初始密码为：" + repassword);
        return new Gson().toJson(ResultVOUtil.success());
    }


    //发送简单文本邮件
    public void sendSimpleEmail(String recipient, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        //发送者
        message.setFrom(sender);
        //接收者
        message.setTo(recipient);
        //邮件主题
        message.setSubject("StudentOA重置密码");
        //邮件内容
        message.setText(text);
        //发送邮件
        javaMailSender.send(message);
    }
    //发送HTML模板邮件
    public void sendTemplateMail(String recipient, String userid){
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(recipient);
            helper.setSubject("StudentOA 注册验证");
            Context context = new Context();
            context.setVariable("id", userid);
            String emailContent = templateEngine.process("emailTemplate", context);
            helper.setText(emailContent, true);
        }catch (MessagingException e){
            throw new RuntimeException("Messaging Exception!" + e);
        }
        javaMailSender.send(message);
    }




}
