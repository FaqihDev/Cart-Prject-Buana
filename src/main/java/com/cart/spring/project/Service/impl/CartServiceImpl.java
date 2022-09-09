package com.cart.spring.project.Service.impl;


import com.cart.spring.project.Common.BaseResponse;
import com.cart.spring.project.Common.ResponseCode;
import com.cart.spring.project.Dto.Response.CartResponseTotalFinalizeDto;
import com.cart.spring.project.Entity.Cart;
import com.cart.spring.project.Entity.Checkout;
import com.cart.spring.project.Entity.Customer;
import com.cart.spring.project.Entity.Product;
import com.cart.spring.project.Exception.DataNotFoundException;
import com.cart.spring.project.Exception.OutOfStockException;
import com.cart.spring.project.Repository.CartRepository;
import com.cart.spring.project.Repository.CheckoutRepository;
import com.cart.spring.project.Repository.CustomerRepository;
import com.cart.spring.project.Repository.ProductRepository;
import com.cart.spring.project.Dto.Request.CartRequest;
import com.cart.spring.project.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public ResponseEntity<?> addProductToCart(CartRequest cartRequest) {

        //Cari produk dan user berdasarkan id
        Product product = productRepository.findById(cartRequest.getProductId()).orElseThrow(()->
                new DataNotFoundException(ResponseCode.FAILED.getCode()));

        Customer customer = customerRepository.findById(cartRequest.getCustomerId()).orElseThrow(()->
                new DataNotFoundException(ResponseCode.FAILED.getCode()));

        if (product.getQuantity() < 1){
            throw new OutOfStockException(ResponseCode.FAILED.getCode());
        }

        //Buat objek cart dan masukan set customer dan product kedalam cart
        Cart cart = new Cart();
        cart.setProductId(product);
        cart.setCustomerId(customer);
        cart.setCreatedBy("USER");
        Date today = Date.from(Instant.now());
        cart.setCreatedDate(today);
        cart.setAmount(product.getPrice());
        cart.setTotalPrice(cartRequest.getQuantity() * product.getPrice());
        cart.setIsCancel(0);

         cartRepository.save(cart);
         return ResponseEntity.ok().body(new BaseResponse<>(ResponseCode.SUCCESS.getCode(),"Add to chart success",null));

    }

    @Override
    public List<Cart> getAllProductInCart(Long userId) {
        Customer customer = customerRepository.findById(userId).orElseThrow(() -> new DataNotFoundException(ResponseCode.FAILED.getCode()));
//        List<Cart> allByCustomerId = cartRepository.findAllByCustomerId(customer);
        List<Cart> allProductByCustomer = cartRepository.findAllProductByCustomerId(customer);

        return allProductByCustomer;
    }

    @Override
    public CartResponseTotalFinalizeDto cartResponseTotalFinalPrice(Long userId) {
        List<Cart> allByCustomerId = this.getAllProductInCart(userId);
        int Total = 0;

        for (Cart cart : allByCustomerId){
            Total = Total +  cart.getTotalPrice();
        }

        CartResponseTotalFinalizeDto c = new CartResponseTotalFinalizeDto();
        Customer customer = customerRepository.findById(userId).orElse(null);
        String name = customer.getName();
        c.setUserId(userId);                                                 
        c.setCustomerName(name);
        c.setTotalPriceInCart(Total);


        Checkout checkout = new Checkout();
        checkout.setCustomerId(customer);
        checkout.setTotalPrice(Total);
        Date now = Date.from(Instant.now());
        checkout.setCreatedDate(now);
        checkout.setTransactionId(UUID.randomUUID().toString());

        checkoutRepository.save(checkout);
        return c;

    }

    @Override
    public void removeCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Optional<List<Cart>> addMoreItemsToCart(CartRequest cartRequest) {
        return Optional.empty();
    }


}
