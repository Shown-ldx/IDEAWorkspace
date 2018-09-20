package com.hstc.studentoauserserver.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {
    @NotEmpty(message = "用户名必填")
    private String username;
    @NotEmpty(message = "性别必填")
    private String sex;
    @NotEmpty(message = "年龄必填")
    private String age;
    @NotEmpty(message = "密码必填")
    private String password;
    @NotEmpty(message = "电话必填")
    private String telephone;
    @NotEmpty(message = "Email必填")
    private String email;

}
