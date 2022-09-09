package com.cart.spring.project.Exception;


import lombok.Data;

@Data
public class OutOfStockException extends RuntimeException {
    private Integer responseCode;
    private String responseMessage = "Product is out of stock";

    public OutOfStockException(Integer responseCode) {
        this.responseCode = responseCode;
    }
}
