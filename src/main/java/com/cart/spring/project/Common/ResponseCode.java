package com.cart.spring.project.Common;

public enum ResponseCode {
    SUCCESS(00),
    FAILED(01);

    ResponseCode(Integer code) {
        this.code = code;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }
}
