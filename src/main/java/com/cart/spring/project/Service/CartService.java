package com.cart.spring.project.Service;

import com.cart.spring.project.Dto.Response.CartResponseTotalFinalizeDto;
import com.cart.spring.project.Entity.Cart;
import com.cart.spring.project.Dto.Request.CartRequest;
import com.cart.spring.project.Entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CartService {

    public ResponseEntity<?> addProductToCart(CartRequest cartRequest);

    public List<Cart> getAllProductInCart (Long userId);

    public CartResponseTotalFinalizeDto cartResponseTotalFinalPrice (Long userId);

    public void removeCart(Long userId);

    public Optional<List<Cart>> addMoreItemsToCart(CartRequest cartRequest);

}
