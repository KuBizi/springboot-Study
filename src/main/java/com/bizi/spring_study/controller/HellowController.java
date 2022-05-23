package com.bizi.spring_study.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 在templates下面的页面只能通过controller访问 需要模板引擎
// restcontroller 是controller 和responsebody 的结合体 只能返回实体对象 不能跳转模板页面 只有controller时可以跳转
@RestController
@RequestMapping()
public class HellowController {
    @RequestMapping("/hello") 
    public String hello() {
        return "hello, world";
    }
}
