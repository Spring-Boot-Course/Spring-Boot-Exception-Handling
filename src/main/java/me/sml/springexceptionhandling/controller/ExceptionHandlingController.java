package me.sml.springexceptionhandling.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import me.sml.springexceptionhandling.exception.DataAccessException;
import me.sml.springexceptionhandling.exception.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Slf4j
@RestController
public class ExceptionHandlingController {

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(){
        log.error("Request Raised a Data Integrity Violation Exception");
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public String databaseError(){
        return "databaseError";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception){
        log.error("Request : " + req.getRequestURL() + " raised " + exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }

    @GetMapping("/dataintegrity")
    public void dataIntegityOrder(){
        throw new DataIntegrityViolationException("wow");
    }

    @GetMapping("/db/{param}")
    public String databaseOrder(@PathVariable("param") long param){
        if(param == 1) throw new DataAccessException("wow");
        return "hello";
    }

    @GetMapping("/handling/{param}")
    public String handleOrder(@PathVariable("param") String param) throws Exception {
        throw new Exception(param);
    }
}
