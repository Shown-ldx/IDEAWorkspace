package com.hstc.studentoauserserver.service.impl;

import com.hstc.studentoauserserver.pojo.User;
import com.hstc.studentoauserserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        User user = new User();
        user.setId("000001");
        user.setUsername("ldx");
        user.setAge(14);
        user.setSex("男");
        user.setTelephone("10086");
        user.setEmail("luodixing@163.com");
        user.setPassword("110");
        User result = userService.saveUser(user);
        Assert.assertEquals(user.getId(), result.getId());
    }
}