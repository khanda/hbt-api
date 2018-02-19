package com.hbt.gd.exception;

import org.springframework.http.HttpStatus;

public class HBTException extends Exception {
    private HttpStatus code;
    private ErrorEnum codeString;

    public HBTException(HttpStatus code, ErrorEnum codeString) {
        this.code = code;
        this.codeString = codeString;
    }

    public HBTException(String message, HttpStatus code, ErrorEnum codeString) {
        super(message);
        this.code = code;
        this.codeString = codeString;
    }

    public ErrorEnum getCodeString() {
        return codeString;
    }

    public void setCodeString(ErrorEnum codeString) {
        this.codeString = codeString;
    }

    public HBTException(HttpStatus code) {
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
