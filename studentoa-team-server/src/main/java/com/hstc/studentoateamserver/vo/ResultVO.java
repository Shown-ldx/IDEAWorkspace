package com.hstc.studentoateamserver.vo;

import lombok.Data;

/**
 * http返回的最外层
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String message;

    private T data;


}
