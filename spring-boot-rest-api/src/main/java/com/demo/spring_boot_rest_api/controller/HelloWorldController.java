package com.demo.spring_boot_rest_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorldController {
    //HTTP get request
    //http://localhost:8080/hello-world
    
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
