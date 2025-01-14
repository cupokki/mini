package io.goorm.mini.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping
    public String test(){
        return "Hello?";
    }
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
}
