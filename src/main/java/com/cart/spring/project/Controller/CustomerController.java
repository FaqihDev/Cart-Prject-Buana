package com.cart.spring.project.Controller;


import com.cart.spring.project.Common.BaseResponse;
import com.cart.spring.project.Common.CommonCode;
import com.cart.spring.project.Common.CommonMessage;
import com.cart.spring.project.Entity.Customer;
import com.cart.spring.project.Service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping
    public BaseResponse<Customer> addUser(@RequestBody Customer param){

        try{
            if (Objects.nonNull(param)){
                customerService.addCustomer(param);
                return new BaseResponse<>(CommonCode.SUCCESS,CommonMessage.SAVED,param);
            } else {
                return new BaseResponse<>(CommonCode.BAD_REQUEST,CommonMessage.NOT_SAVED);
            }
        } catch (Exception e){
            return new BaseResponse<>(CommonCode.NOT_FOUND,CommonMessage.ERROR);
        }
    }
}
