package com.hstc.studentoauserserver.converter;

import com.hstc.studentoauserserver.form.UserForm;
import com.hstc.studentoauserserver.pojo.User;
import com.hstc.studentoauserserver.util.KeyUtil;
import org.springframework.beans.BeanUtils;

public class UserForm2UserConverter {
    public static User convert(UserForm userForm){
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
//        user.setAge(Integer.parseInt(userForm.getAge()));
        user.setId(KeyUtil.genUniqueKey());
        return user;
    }
}
