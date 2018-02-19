package com.hbt.gd.exception;

public enum ErrorEnum {
    DUPLICATED("DUPLICATED"),
    ERROR("ERROR");

    private String code;


    ErrorEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
