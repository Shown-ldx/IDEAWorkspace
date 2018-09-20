package com.hstc.studentoauserserver.exception;

import com.hstc.studentoauserserver.enums.UserEnum;

public class UserException extends RuntimeException {
    private Integer code;

    public UserException(Integer code, String message){
        super(message);
        this.code = code;
    }
    public UserException(UserEnum userEnum){
        super(userEnum.getMessage());
        this.code = userEnum.getCode();
    }
}
