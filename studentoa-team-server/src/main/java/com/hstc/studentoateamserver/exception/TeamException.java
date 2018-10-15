package com.hstc.studentoateamserver.exception;

import com.hstc.studentoateamserver.enums.TeamEnum;

public class TeamException extends RuntimeException {
    private Integer code;

    public TeamException(Integer code, String message){
        super(message);
        this.code = code;
    }
    public TeamException(TeamEnum teamEnum){
        super(teamEnum.getMessage());
        this.code = teamEnum.getCode();
    }
}
