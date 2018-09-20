package com.hstc.studentoauserserver.pojo;

import com.hstc.studentoauserserver.enums.UserEnum;
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

    private Integer status= UserEnum.INACTIVATED.getCode();

    private Date createTime = new Date();

    private Date updateTime;

}
