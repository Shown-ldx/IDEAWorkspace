package com.hstc.studentoafriendserver.service.impl;

import com.hstc.studentoafriendserver.mapper.FriendMapper;
import com.hstc.studentoafriendserver.pojo.Friend;
import com.hstc.studentoafriendserver.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<Friend> selectMyFriendsById(String userId, Integer currPage, Integer pageSize) {
        List<Friend> friendList = friendMapper.selectMyFriendsById(userId, pageSize*(currPage-1), pageSize);
        return friendList;
    }

    @Override
    public Friend saveFriend(Friend friend) {
        return null;
    }

    @Override
    public Integer deleteFriendById(String id) {
        return null;
    }

    @Override
    public Friend updateFriendRemarks(Friend friend) {
        return null;
    }

    @Override
    public Integer selectPages(Integer pageSize) {
        return null;
    }
}
