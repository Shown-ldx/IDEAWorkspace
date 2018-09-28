package com.hstc.studentoafriendserver.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Friend {
    //
    private String id;
    //用户id
    private String userId;
    //好友id
    private String friendId;
    //好友备注
    private String remarks;

    private Date createTime;

    private Date updateTime;

}
