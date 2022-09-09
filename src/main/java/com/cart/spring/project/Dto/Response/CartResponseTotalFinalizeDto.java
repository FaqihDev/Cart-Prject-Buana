package com.cart.spring.project.Dto.Response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartResponseTotalFinalizeDto {
    private Long userId;
    private String customerName;
    private Integer TotalPriceInCart;
}
