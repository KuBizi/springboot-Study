package com.bizi.spring_study.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller 
public class IndexController {
    @RequestMapping("user/login")
    //@ResponseBody
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        request.getHeader("webSite");
        HttpSession session = request.getSession();
        // session.s
        if (username.equals(password)) {
            return "404";
        }
    return "dashboard";
}

}
