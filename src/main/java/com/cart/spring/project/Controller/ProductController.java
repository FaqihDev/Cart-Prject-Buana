package com.cart.spring.project.Controller;


import com.cart.spring.project.Common.BaseResponse;
import com.cart.spring.project.Common.CommonCode;
import com.cart.spring.project.Common.CommonMessage;
import com.cart.spring.project.Entity.Product;
import com.cart.spring.project.Service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public BaseResponse<Product> addProduct(@RequestBody Product product){
        try{
            if (Objects.nonNull(product)){
                productService.addProduct(product);
                return new BaseResponse<>(CommonCode.SUCCESS, CommonMessage.SAVED,product);
            } else {
                return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.NOT_SAVED);
            }
        } catch (Exception e){
            return new BaseResponse<>(CommonCode.NOT_FOUND,CommonMessage.ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public BaseResponse<Product> getProductById(@PathVariable("id") Long id){
        try{
            Product product =  productService.getProductById(id).get();
            if (Objects.nonNull(product)) {
                return new BaseResponse<>(CommonCode.SUCCESS,CommonMessage.FOUND,product);
            } else {
                return new BaseResponse<>(CommonCode.NOT_FOUND,CommonMessage.NOT_FOUND);
            }

            } catch (RuntimeException e){
                return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.NOT_FOUND);
            }
       }

       @PutMapping(value = "/{id}")
       public BaseResponse<Product> updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
            try{
               if (Objects.nonNull(product)) {
                    productService.updateProduct(id,product);
                    return new BaseResponse<>(CommonCode.SUCCESS,CommonMessage.UPDATED,product);
                } else {
                   return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.NOT_UPDATED);
               }
            } catch (Exception e){
                return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.ERROR);
            }
       }

       @DeleteMapping(value = "/{id}")
       public BaseResponse<Product> deleteProduct(@PathVariable Long id){
            try{
                if (Objects.nonNull(id)){
                    productService.deleteProduct(id);
                    return new BaseResponse<>(CommonCode.SUCCESS,CommonMessage.DELETED);
                } else {
                    return new BaseResponse<>(CommonCode.NOT_FOUND,CommonMessage.NOT_DELETED);
                }
            } catch (Exception e){
                return new BaseResponse<>(CommonCode.NOT_FOUND,CommonMessage.NOT_DELETED);
            }
       }

}
