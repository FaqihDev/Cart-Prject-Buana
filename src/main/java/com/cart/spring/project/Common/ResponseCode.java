package com.cart.spring.project.Common;

public enum ResponseCode {
    SUCCESS("00"),
    FAILED("01");

    ResponseCode(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
