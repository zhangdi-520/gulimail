package com.atguigu.common.exception;

/**
 * @program: gulimail
 * @description: 状态码枚举类
 * @author: Mr.Wang
 * @create: 2020-07-04 18:25
 **/
public enum BizCodeEnume {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VAILD_EXCEPTION(10001,"参数格式检验失败");

    private int code;
    private String message;
    BizCodeEnume(int code,String message){
        this.code = code;
        this.message = message;
    }
    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
