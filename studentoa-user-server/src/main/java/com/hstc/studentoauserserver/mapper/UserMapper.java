package com.hstc.studentoauserserver.mapper;


import com.hstc.studentoauserserver.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

public interface UserMapper {
    @SelectProvider(type=SqlBuilder.class, method="findByEmail")
    public User selectUserByEmail(@Param("email") String email);
    
}
