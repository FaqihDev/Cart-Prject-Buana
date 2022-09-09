package com.cart.spring.project.Dto.Response;

import com.cart.spring.project.Entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CartResponseGetAllProduct {

    private String CustomerName;
    private Long totalProduct;
    private Long totalPrice;
}
