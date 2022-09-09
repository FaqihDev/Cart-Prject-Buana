package com.cart.spring.project.Exception;


import lombok.Data;

@Data
public class OutOfStockException extends RuntimeException {
    private String responseCode;
    private String responseMessage = "Product is out of stock";

    public OutOfStockException(String responseCode) {
        this.responseCode = responseCode;
    }
}
