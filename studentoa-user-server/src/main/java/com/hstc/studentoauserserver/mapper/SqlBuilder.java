package com.hstc.studentoauserserver.mapper;

import com.hstc.studentoauserserver.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilder {//与provider（type=SqlBuilder.class, method=""）type对应
    //以下的方法名与provider（type=*.class, method=""）的method对应
    //方法返回类型必须是String
    //方法中使用@Param("name", String name)，可以来拼接sql并返回
    //使用这种方法，注意不要重载，此外，还接受Map<String, Object>作为参数
    public String findByEmail(@Param("email") String email){
        String sql = "select * from user where email = #{email}";
        return sql;
    }

    public String saveUser(@Param("user") User user){

        String sql = "insert into user(id, username, sex, age, password, email, status, create_time)"
                + "values(#{user.id}, #{user.username}, #{user.sex}, #{user.age}, #{user.password}, #{user.email}, #{user.status}, #{user.createTime})";
        return sql;
    }

    public String updateUser(@Param("user") User user){
        SQL sql = new SQL();
        sql.UPDATE("user");
        if (user.getUsername() != null){
            sql.SET("username = #{user.username}");
        }
        if (user.getAge() != null){
            sql.SET("age = #{user.age}");
        }
        if (user.getSex() != null){
            sql.SET("sex = #{user.sex}");
        }
        if (user.getStatus() != null){
            sql.SET("status = #{user.status}");
        }
        if (user.getTelephone() != null){
            sql.SET("telephone = #{user.telephone}");
        }
        //自己感觉不安全，应该独立起来，以后发现问题再优化
        if (user.getPassword() != null){
            sql.SET("password = #{user.password}");
        }
        sql.WHERE("id = #{user.id}");
        return sql.toString();
    }
}
