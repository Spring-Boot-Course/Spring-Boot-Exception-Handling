package me.sml.springexceptionhandling.controller;

import me.sml.springexceptionhandling.exception.TestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAdviceController {

    @GetMapping("/")
    public void executeException(){
        throw new TestException("TEST");
    }
}
