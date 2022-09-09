package com.cart.spring.project.Controller.handler;

import com.cart.spring.project.Common.BaseResponse;
import com.cart.spring.project.Exception.DataNotFoundException;
import com.cart.spring.project.Exception.OutOfStockException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse dataNotFoundHandle (DataNotFoundException e){
        return new BaseResponse<>(Integer.valueOf(e.getResponseCode()),e.getResponseMessage());
    }

    @ExceptionHandler(OutOfStockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse outOfStockHandle(OutOfStockException e){
        return new BaseResponse<>(Integer.valueOf(e.getResponseCode()),e.getResponseMessage());
    }

}
