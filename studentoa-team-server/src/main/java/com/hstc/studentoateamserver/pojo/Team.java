package com.hstc.studentoateamserver.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Team {
    private String id;

    private String taskname;

    private Integer progress;

    private Integer substackNumber;

    private String userEmail;

    private String description;

    private Integer status;

    private Date startTime;

    private Date endTime;
}
