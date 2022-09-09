package com.cart.spring.project.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException{

    private String responseCode;
    private String responseMessage;

    public DataNotFoundException(String responseCode) {
        this.responseCode = responseCode;
    }
}
