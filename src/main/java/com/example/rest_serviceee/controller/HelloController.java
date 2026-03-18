package com.example.rest_serviceee.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-world")
    public String HelloWorld(){
        return "Hello World !";
    }
}
