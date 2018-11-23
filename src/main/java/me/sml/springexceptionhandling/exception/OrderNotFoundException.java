package me.sml.springexceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "No Such Order")  //404
public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(long orderId) {
        super(orderId + " not found");
    }
}
