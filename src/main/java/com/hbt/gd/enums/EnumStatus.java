package com.hbt.gd.enums;

public enum EnumStatus {
    ERROR("ERROR"),
    SUCCESS("SUCCESS");

    private String status;

    EnumStatus() {
    }

    EnumStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}