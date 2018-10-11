package com.hstc.studentoafriendserver.controller;

import com.google.gson.Gson;
import com.hstc.studentoafriendserver.pojo.Friend;
import com.hstc.studentoafriendserver.service.FriendService;
import com.hstc.studentoafriendserver.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend")
@Slf4j
public class FriendController {
    @Autowired
    private FriendService friendService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/list")
    public String friendList(@RequestParam("email") String email,
                             @RequestParam(value = "currPage", defaultValue = "1") Integer currPage,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){

        String userId = stringRedisTemplate.opsForValue().get(email);
        if (userId == null) {
            log.error("用户未登陆或者登陆异常。");
            return new Gson().toJson(ResultVOUtil.error(9999, "用户未登陆或登陆状态异常，请重新登陆"));
        }
        List<Friend> friendList = friendService.selectMyFriendsById(userId, currPage, pageSize);
        return new Gson().toJson(ResultVOUtil.success(friendList));
    }
}
