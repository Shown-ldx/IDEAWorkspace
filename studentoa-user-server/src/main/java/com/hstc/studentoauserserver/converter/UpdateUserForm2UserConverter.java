package com.hstc.studentoauserserver.converter;

import com.hstc.studentoauserserver.enums.UserEnum;
import com.hstc.studentoauserserver.form.UpdateUserForm;
import com.hstc.studentoauserserver.pojo.User;
import org.springframework.beans.BeanUtils;

public class UpdateUserForm2UserConverter {
    public static User convert(UpdateUserForm updateUserForm){
        User user = new User();
        BeanUtils.copyProperties(updateUserForm, user);
        user.setStatus(null);
        return user;
    }

}
