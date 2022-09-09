package com.cart.spring.project.Controller;


import com.cart.spring.project.Common.BaseResponse;
import com.cart.spring.project.Common.CommonCode;
import com.cart.spring.project.Common.CommonMessage;
import com.cart.spring.project.Dto.Response.CartResponseGetAllProduct;
import com.cart.spring.project.Dto.Response.CartResponseTotalFinalizeDto;
import com.cart.spring.project.Entity.Cart;
import com.cart.spring.project.Dto.Request.CartRequest;
import com.cart.spring.project.Service.impl.CartServiceImpl;
import com.cart.spring.project.Service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping
    public BaseResponse<Cart> addProductToCart(@RequestBody CartRequest cartRequest){
        try{
            cartService.addProductToCart(cartRequest);
            return new BaseResponse(CommonCode.SUCCESS, CommonMessage.SAVED,cartRequest);
        } catch (Exception e){
            return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.NOT_SAVED);
        }
    }

    @GetMapping(value = "/{userId}")
    public BaseResponse<CartResponseGetAllProduct> allProductInCart (@PathVariable("userId") Long userId){
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
