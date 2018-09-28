package com.hstc.studentoafriendserver.mapper;

import com.hstc.studentoafriendserver.pojo.Friend;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FriendMapperTest {
    @Autowired
    private FriendMapper friendMapper;

    @Test
    public void selectMyFriendsById() {
        String userId = "01";
        Integer begin = 0;
        Integer pageSize = 5;
        List<Friend> friendList;
        friendList = friendMapper.selectMyFriendsById(userId, begin, pageSize);
        for (Friend friend : friendList){
            log.error(friend.getId()+"--"+friend.getUserId()+"--"+friend.getFriendId()+"---"
                    +friend.getRemarks()+"--"+friend.getCreateTime()+"--"+friend.getUpdateTime());
        }

    }

    @Test
    public void saveFriend() {

    }
}