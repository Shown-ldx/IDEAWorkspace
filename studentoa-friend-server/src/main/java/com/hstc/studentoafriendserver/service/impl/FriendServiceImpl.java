package com.hstc.studentoafriendserver.service.impl;

import com.hstc.studentoafriendserver.mapper.FriendMapper;
import com.hstc.studentoafriendserver.pojo.Friend;
import com.hstc.studentoafriendserver.service.FriendService;
import com.hstc.studentoafriendserver.vo.FriendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<FriendVO> selectMyFriendsById(String userId, Integer currPage, Integer pageSize) {
        List<Friend> friendList = friendMapper.selectMyFriendsById(userId, pageSize*(currPage-1), pageSize);
        List<FriendVO> friendVOList = new ArrayList<>();
        //将Friend封装成FriendVO
        for (Friend friend : friendList){
            FriendVO friendVO = new FriendVO();
            friendVO.setFriendEmail(friend.getFriendEmail());
            friendVO.setRemarks(friend.getRemarks());
            friendVO.setCreateTime(friend.getCreateTime());
            friendVOList.add(friendVO);
        }
        return friendVOList;
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
        Integer numberOfFriends = friendMapper.selectNumberOfFriends();

        return (numberOfFriends % pageSize == 0 ? numberOfFriends/pageSize : numberOfFriends/pageSize+1);
    }
}
