package com.bizi.spring_study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HellowController {
    @RequestMapping("/hello") 
    public String hello() {
        return "hello, world";
    }
}
