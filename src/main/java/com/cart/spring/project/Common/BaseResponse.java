package com.cart.spring.project.Common;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -6233145663410668178L;

    private Integer code = 999;
    private String message;
    private T data;

    private String responseCode;

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public BaseResponse(String message) {
        this.message = message;
    }

    public BaseResponse(Integer code, String message, T data, String responseCode) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String code, String add_to_chart_success, Object data) {
    }
}
