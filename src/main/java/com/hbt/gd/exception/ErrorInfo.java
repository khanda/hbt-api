package com.hbt.gd.exception;

public class ErrorInfo {
    private ErrorEnum code;

    public ErrorInfo() {
    }

    public ErrorInfo(ErrorEnum code) {
        this.code = code;
    }

    public ErrorEnum getCode() {
        return code;
    }

    public void setCode(ErrorEnum code) {
        this.code = code;
    }
}
