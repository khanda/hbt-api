package com.hbt.gd.helper;

import com.hbt.gd.enums.EnumStatus;

public class SimpleResponse2<T> {
    private EnumStatus status;
    private String message;
    private T data;

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
