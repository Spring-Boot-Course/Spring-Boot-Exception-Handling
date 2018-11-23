package me.sml.springexceptionhandling.controller;

import me.sml.springexceptionhandling.exception.OrderNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/orders/{id}")
    public String showOrder(@PathVariable("id") long id){
        throw new OrderNotFoundException(id);
    }

}
