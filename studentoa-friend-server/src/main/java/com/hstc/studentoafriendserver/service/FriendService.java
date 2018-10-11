package com.hstc.studentoafriendserver.service;

import com.hstc.studentoafriendserver.pojo.Friend;
import com.hstc.studentoafriendserver.vo.FriendVO;


import java.util.List;

public interface FriendService {
    //通过好友id返回好友列表当前页数据
    public List<FriendVO> selectMyFriendsById(String userId, Integer currPage, Integer pageSize);
    public Friend saveFriend(Friend friend);
    public Integer deleteFriendById(String id);
    public Friend updateFriendRemarks(Friend friend);
    //根据页的大小，返回好友列表页数
    public Integer selectPages(Integer pageSize);
}
