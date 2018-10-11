package com.hstc.studentoafriendserver.vo;

import lombok.Data;

import java.util.Date;

@Data
public class FriendVO {
        private String friendEmail;
        private String remarks;
        private Date createTime;
}
