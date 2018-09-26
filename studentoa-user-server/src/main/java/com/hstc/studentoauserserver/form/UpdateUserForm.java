package com.hstc.studentoauserserver.form;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdateUserForm {

    @NotEmpty(message = "用户id必有")
    private String id;

    private String username;

    private String sex;
    //不能注解非空，不然它会转换为String类型
    private Integer age;

    private String telephone;
    @NotEmpty(message = "用户email必有")
    private String email;

}
