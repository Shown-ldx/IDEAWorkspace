package com.hstc.studentoafriendserver.service.impl;

import com.hstc.studentoafriendserver.pojo.Friend;
import com.hstc.studentoafriendserver.service.FriendService;
import com.hstc.studentoafriendserver.vo.FriendVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FriendServiceImplTest {
    @Autowired
    private FriendService friendService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void selectMyFriendById() {
        String userId = "02";
        Integer currPage = 1;
        Integer pageSize = 5;
        List<FriendVO> friendVOList;
        friendVOList = friendService.selectMyFriendsById(userId, currPage, pageSize);
        for (FriendVO friend : friendVOList){
            log.error(friend.getFriendEmail() + "---" +friend.getRemarks() + "--"+friend.getCreateTime());
        }
    }

    @Test
    public void saveFriend() {

    }

    @Test
    public void deleteFriendById() {
    }

    @Test
    public void updateFriendRemarks() {
    }

    @Test
    public void selectPages() {
        Integer result = friendService.selectPages(5);
        log.error(result.toString());
    }
}