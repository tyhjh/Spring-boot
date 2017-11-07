package com.yorhp.girl.enums;

public enum ResultEnum {
    UNKNOW_ERRO(-1,"未知错误"),
    SUCCESS(200,"成功"),
    TOO_YOUNG(101,"你太年轻了"),
    TOO_SIMPLE(102,"你太傻了"),
    ;
    private Integer code;
    private String msg;




    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
