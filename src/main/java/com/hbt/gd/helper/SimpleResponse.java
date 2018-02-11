package com.hbt.gd.helper;

import com.hbt.gd.enums.EnumStatus;

import java.util.List;

public class SimpleResponse<T> {
    private EnumStatus status;
    private String message;
    private List<T> data;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
