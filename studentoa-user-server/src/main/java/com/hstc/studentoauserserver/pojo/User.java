package com.hstc.studentoauserserver.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;

    private String username;

    private String sex;

    private Integer age;

    private String password;

    private String telephone;

    private String email;

    private Date createTime;

    private Date updateTime;

}
