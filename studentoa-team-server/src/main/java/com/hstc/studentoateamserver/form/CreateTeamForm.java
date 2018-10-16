package com.hstc.studentoateamserver.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class CreateTeamForm {
    @NotEmpty(message = "团队主任务名必填")
    private String taskname;
    @NotEmpty(message = "组长Email必填")
    private String UserEmail;

    private String description;

    private Date startTime;
    
    private Date endTime;
}
