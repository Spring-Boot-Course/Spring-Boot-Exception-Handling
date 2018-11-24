package me.sml.springexceptionhandling.advice;

import me.sml.springexceptionhandling.dto.ErrorMessage;
import me.sml.springexceptionhandling.exception.TestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class TestAdvice {

    @ExceptionHandler({TestException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Test Exception Occurred !")
    @ResponseBody
    protected ErrorMessage handleConflict(RuntimeException e, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(HttpStatus.CONFLICT.toString());
        errorMessage.setMessage(e.toString());
        return errorMessage;
    }
}
