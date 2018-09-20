package com.hstc.studentoauserserver.mapper;


import com.hstc.studentoauserserver.pojo.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UserMapper {
    @SelectProvider(type=SqlBuilder.class, method="findByEmail")
    public User selectUserByEmail(@Param("email") String email);

    @InsertProvider(type = SqlBuilder.class, method = "saveUser")
    public Integer saveUser(@Param("user") User user);

    @UpdateProvider(type = SqlBuilder.class, method = "updateUser")
    public Integer updateUser(@Param("user") User user);
}
