package com.hstc.studentoafriendserver.service;

import com.hstc.studentoafriendserver.pojo.Friend;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;


import java.util.Arrays;
import java.util.List;

public interface FriendService {
    public List<Friend> selectMyFriendsById(String userId, Integer currPage, Integer pageSize);
    public Friend saveFriend(Friend friend);
    public Integer deleteFriendById(String id);
    public Friend updateFriendRemarks(Friend friend);
}
