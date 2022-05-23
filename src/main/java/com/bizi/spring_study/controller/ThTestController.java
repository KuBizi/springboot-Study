package com.bizi.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 在templates下面的页面只能通过controller访问 需要模板引擎
@Controller
public class ThTestController {
    @RequestMapping("/thTest")
    public String thTest(Model model) {
        model.addAttribute("msg","hello,THtest");
        return "ThTest";
    }
}