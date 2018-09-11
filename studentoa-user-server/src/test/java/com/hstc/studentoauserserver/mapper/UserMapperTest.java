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
        log.error(user.getUsername());
        Assert.assertNotEquals(1, user.getId());
    }
}