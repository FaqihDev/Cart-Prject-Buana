package com.cart.spring.project.Controller;


import com.cart.spring.project.Common.BaseResponse;
import com.cart.spring.project.Common.CommonCode;
import com.cart.spring.project.Common.CommonMessage;
import com.cart.spring.project.Dto.Response.CartResponse;
import com.cart.spring.project.Dto.Response.CartResponseTotalFinalizeDto;
import com.cart.spring.project.Entity.Cart;
import com.cart.spring.project.Dto.Request.CartRequest;
import com.cart.spring.project.Entity.Customer;
import com.cart.spring.project.Entity.Product;
import com.cart.spring.project.Repository.CustomerRepository;
import com.cart.spring.project.Repository.ProductRepository;
import com.cart.spring.project.Service.impl.CartServiceImpl;
import com.cart.spring.project.Service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public BaseResponse<Cart> addProductToCart(@RequestBody CartRequest cartRequest){
        try{
            cartService.addProductToCart(cartRequest);
            CartResponse cartResponse = new CartResponse();
            Customer customer = customerRepository.findById(cartRequest.getCustomerId()).get();
            Product product = productRepository.findById(cartRequest.getProductId()).get();
            cartResponse.setCustomerName(customer.getName());
            cartResponse.setProductName(product.getName());
            cartResponse.setTransaction(UUID.randomUUID().toString());

            return new BaseResponse(CommonCode.SUCCESS, CommonMessage.SAVED,cartResponse);
        } catch (Exception e){
            return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.NOT_SAVED);
        }
    }

    @GetMapping(value = "/{userId}")
    public BaseResponse<Cart> allProductInCart (@PathVariable("userId") Long userId){
        try{
           List<Cart> allProductsInCart = cartService.getAllProductInCart(userId);
           return new BaseResponse(CommonCode.SUCCESS,CommonMessage.FOUND,allProductsInCart);
        } catch (RuntimeException e){
            return new BaseResponse<>(CommonCode.NOT_FOUND,"Data di keranjang tidak berhasil ditemukan");
        } catch (Exception e){
            return new BaseResponse<>(CommonCode.FORBIDDEN,CommonMessage.ERROR);
        }
    }

    @PostMapping(value = "/{userId}")
    public BaseResponse<CartResponseTotalFinalizeDto> finalizeDtoBaseResponse (@PathVariable("userId") Long userId){
        try{
            CartResponseTotalFinalizeDto cartResponse = cartService.cartResponseTotalFinalPrice(userId);
            return new BaseResponse(CommonCode.SUCCESS,CommonMessage.OK,cartResponse);
        } catch (RuntimeException e){
            return new BaseResponse(CommonCode.NOT_FOUND,CommonMessage.NOT_FOUND);
        } catch (Exception e){
            return new BaseResponse(CommonCode.BAD_REQUEST,CommonMessage.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public BaseResponse<Cart> removeCart(@PathVariable("id") Long id){
        try{
            cartService.removeCart(id);
            return new BaseResponse<>(CommonCode.SUCCESS,CommonMessage.DELETED);
        } catch (RuntimeException e){
            return new BaseResponse<>(CommonCode.NOT_FOUND,CommonMessage.NOT_DELETED);
        } catch (Exception e){
            return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.NOT_DELETED);
        }
    }
}
