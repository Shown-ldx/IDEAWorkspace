package com.hstc.studentoauserserver.controller;

import com.google.gson.Gson;
import com.hstc.studentoauserserver.converter.UserForm2UserConverter;
import com.hstc.studentoauserserver.enums.UserEnum;
import com.hstc.studentoauserserver.exception.UserException;
import com.hstc.studentoauserserver.form.UserForm;
import com.hstc.studentoauserserver.pojo.User;
import com.hstc.studentoauserserver.service.UserService;
import com.hstc.studentoauserserver.util.ResultVOUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

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

    @Value("${spring.mail.username}")
    private String sender;

    @GetMapping("/login")
    public String Login(){
        return "hello world";
    }

    @PostMapping("/register")
    public String RegisterUser(@Valid UserForm userForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("用户注册信息不正确");
            throw new UserException(UserEnum.PARAM_ERRER.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        User user = UserForm2UserConverter.convert(userForm);
        User result = userService.saveUser(user);
        sendTemplateMail(result.getEmail(), result.getId());
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
