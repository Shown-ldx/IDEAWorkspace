package com.hstc.studentoateamserver.util;

import com.hstc.studentoateamserver.vo.ResultVO;

public class ResultVOUtil {
    //成功状态，并返回数据
 public static ResultVO success(Object object){
     ResultVO resultVO = new ResultVO();
     resultVO.setData(object);
     resultVO.setCode(0);
     resultVO.setMessage("成功");
     return resultVO;
 }
    //成功状态，不返回数据
 public static ResultVO success(){
     return success(null);
 }
    //错误状态，返回错误码和错误消息
 public static ResultVO error(Integer code, String msg){
     ResultVO resultVO = new ResultVO();
     resultVO.setCode(code);
     resultVO.setMessage(msg);
     return resultVO;
 }
}
