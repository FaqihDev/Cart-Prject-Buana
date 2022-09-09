package com.cart.spring.project.Dto.Request;


import lombok.Data;



@Data
public class CartRequest {

    private Long customerId;

    private Long productId;

    private Integer quantity;
}
