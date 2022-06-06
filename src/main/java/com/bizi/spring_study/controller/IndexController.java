package com.bizi.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller 
public class IndexController {
    @RequestMapping("user/login")
    @ResponseBody
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password){
        if (username.equals(password)) {
            return "404";
        }
    return "dashboard";
}
}
