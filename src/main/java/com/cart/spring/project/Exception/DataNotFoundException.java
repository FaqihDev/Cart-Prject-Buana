package com.cart.spring.project.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{

    private Integer responseCode;
    private String responseMessage;

    public DataNotFoundException(Integer responseCode) {
        this.responseCode = responseCode;
    }
}
