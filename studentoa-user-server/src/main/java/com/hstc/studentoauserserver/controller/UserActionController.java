package com.hstc.studentoauserserver.controller;

import com.google.gson.Gson;
import com.hstc.studentoauserserver.converter.UpdateUserForm2UserConverter;
import com.hstc.studentoauserserver.enums.UserEnum;
import com.hstc.studentoauserserver.exception.UserException;
import com.hstc.studentoauserserver.form.UpdateUserForm;
import com.hstc.studentoauserserver.form.UserForm;
import com.hstc.studentoauserserver.pojo.User;
import com.hstc.studentoauserserver.service.UserService;
import com.hstc.studentoauserserver.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/userAction")
public class UserActionController {
    @Autowired
    private UserService userService;



    //通过Email查找用户信息
    @GetMapping("/findUser")
    public String findUser(@RequestParam("email") String email,  HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");             //设置请求头，使浏览器能跨域得到数据
        User user = userService.selectUserByEmail(email);
        return new Gson().toJson(ResultVOUtil.success(user));
    }
    //修改用户信息（通过用户id）
    @PostMapping("/updateUser")
    public String updateUser(@Valid UpdateUserForm updateUserForm, BindingResult bindingResult, HttpServletResponse response){

        if (bindingResult.hasErrors()){
            log.error("用户注册信息不正确");
            throw new UserException(UserEnum.PARAM_ERRER.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        response.setHeader("Access-Control-Allow-Origin", "*");

        User user = UpdateUserForm2UserConverter.convert(updateUserForm);

        //更新用户信息
        User result = userService.updateUser(user);

        return new Gson().toJson(ResultVOUtil.success(result));
    }
}
