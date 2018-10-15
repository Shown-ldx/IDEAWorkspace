package com.hstc.studentoateamserver.enums;

import lombok.Getter;

@Getter
public enum TeamEnum {
    PROCESSING(0, "任务进行中"),
    FINISH(1, "任务完成"),
    EXPIRED(2, "任务过期"),
    DEATH(3, "任务死亡"),

    ;
    private Integer code;
    private String message;

    TeamEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
