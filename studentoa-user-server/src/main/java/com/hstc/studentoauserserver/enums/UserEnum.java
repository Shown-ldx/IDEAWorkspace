package com.hstc.studentoauserserver.enums;

import lombok.Getter;

@Getter
public enum UserEnum {
    ACTIVATED(0, "激活"),
    INACTIVATED(1, "未激活"),
    ;
    private Integer code;
    private String message;

    UserEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
