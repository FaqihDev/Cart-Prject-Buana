package com.cart.spring.project.Dto.Request;


import com.cart.spring.project.Entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CartRequest {

    private Long customerId;

    private Long productId;

    private List<Product> productList;

    private Integer quantity;
}
