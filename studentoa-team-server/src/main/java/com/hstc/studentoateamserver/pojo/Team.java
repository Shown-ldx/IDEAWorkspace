package com.hstc.studentoateamserver.pojo;

import com.hstc.studentoateamserver.enums.TeamEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Team {
    private String id;

    private String taskname;

    private Integer progress = 0;      //默认值为0，即刚开始，100完成

    private Integer substackNumber = 0;    //默认值为0，即没有子任务。

    private String userEmail;

    private String description;

    private Integer status = TeamEnum.PROCESSING.getCode(); //默认值为进行中

    private Date startTime;

    private Date endTime;
}
