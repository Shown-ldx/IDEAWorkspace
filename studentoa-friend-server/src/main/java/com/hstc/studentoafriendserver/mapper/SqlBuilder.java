package com.hstc.studentoafriendserver.mapper;

import com.hstc.studentoafriendserver.pojo.Friend;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilder {
    public String selectMyFriendsById(@Param("userId") String userId,
                                      @Param("begin") Integer begin,
                                      @Param("pageSize") Integer pageSize){
        String sql = "select * from friend where user_id = #{userId} limit #{begin},#{pageSize}";
        return sql;
    }

    public String saveFriend(@Param("friend") Friend friend){
        String sql = "";
        return sql;
    }

    public String deleteFriendById(@Param("id") String id){
        String sql = "";
        return sql;
    }

    public String updateFriendRemarks(@Param("friend") Friend friend){
        String sql = "";
        return sql;
    }
}
