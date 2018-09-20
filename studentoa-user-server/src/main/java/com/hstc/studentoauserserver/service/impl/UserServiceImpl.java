package com.hstc.studentoauserserver.service.impl;

import com.hstc.studentoauserserver.enums.UserEnum;
import com.hstc.studentoauserserver.exception.UserException;
import com.hstc.studentoauserserver.mapper.UserMapper;
import com.hstc.studentoauserserver.pojo.User;
import com.hstc.studentoauserserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User saveUser(User user) {
        User user1 = userMapper.selectUserByEmail(user.getEmail());
        if(user1 != null){
            if (user1.getStatus() == UserEnum.INACTIVATED.getCode()){
                user.setId(user1.getId());
                Integer result1 = userMapper.updateUser(user);
                if(result1 < 0) log.error("数据库更新出问题！");
                return user;
            }else{
                log.error("邮箱已经被注册!");
                throw new UserException(UserEnum.EMAIL_EXIST);
            }
        }
        Integer result = userMapper.saveUser(user);
        if(result < 0) log.error("数据库插入又出问题！");
        return user;
    }
}
