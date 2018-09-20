package com.hstc.studentoauserserver.mapper;

import com.hstc.studentoauserserver.pojo.User;
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
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUserByEmail(){
        String email = "Ldixing@163.com";
        User user = userMapper.selectUserByEmail(email);
        if (user == null){
            log.error("------------------------++++++++++++++++++++++++是空值");
        }
        log.error(user.getUsername());
        log.error(user.getUpdateTime().toString());
        Assert.assertNotEquals(1, user.getId());
    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setId("000001");
        user.setUsername("ldx");
        user.setAge(14);
        user.setSex("男");
        user.setEmail("luodixing@163.com");
        user.setPassword("110");
        Integer result = userMapper.saveUser(user);
        log.error("-------------------------------------------"+String.valueOf(result));
    }

    @Test
    public void updateUser(){
        String email = "Ldixing@163.com";
        User user = userMapper.selectUserByEmail(email);
        user.setAge(18);
        user.setPassword("luodixing");
        Integer result = userMapper.updateUser(user);
        log.error("++++++++++++++++++++++++++++++++++++++++"+String.valueOf(result));
    }
}