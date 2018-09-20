package com.hstc.studentoauserserver.service;

import com.hstc.studentoauserserver.pojo.User;

public interface UserService {
    public User saveUser(User user);
    public User selectUserByEmail(String email);
    public User updateUser(User user);
}
