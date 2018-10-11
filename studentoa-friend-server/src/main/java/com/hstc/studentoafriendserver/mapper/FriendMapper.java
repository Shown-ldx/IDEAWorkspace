package com.hstc.studentoafriendserver.mapper;

import com.hstc.studentoafriendserver.pojo.Friend;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FriendMapper {
    @SelectProvider(type = SqlBuilder.class, method = "selectMyFriendsById")
    public List<Friend> selectMyFriendsById(@Param("userId") String userId,
                                            @Param("begin") Integer begin,
                                            @Param("pageSize") Integer pageSize);

    @Select("select count(*) from friend")
    public Integer selectNumberOfFriends();

    @InsertProvider(type = SqlBuilder.class, method = "saveFriend")
    public Integer saveFriend(@Param("friend") Friend friend);

    @DeleteProvider(type = SqlBuilder.class, method = "deleteFriendById")
    public Integer deleteFriendById(@Param("id") String id);

    @UpdateProvider(type = SqlBuilder.class, method = "updateFriendRemarks")
    public Integer updateFriendRemarks(@Param("friend") Friend friend);
}
