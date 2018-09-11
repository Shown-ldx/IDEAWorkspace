package com.hstc.studentoauserserver.mapper;

import org.apache.ibatis.annotations.Param;

public class SqlBuilder {//与provider（type=SqlBuilder.class, method=""）type对应
    //以下的方法名与provider（type=*.class, method=""）的method对应
    //方法返回类型必须是String
    //方法中使用@Param("name", String name)，可以来拼接sql并返回
    //使用这种方法，注意不要重载，此外，还接受Map<String, Object>作为参数
    public String findByEmail(@Param("email") String email){
        String sql = "select * from user where email = #{email}";
        return sql;
    }
}
