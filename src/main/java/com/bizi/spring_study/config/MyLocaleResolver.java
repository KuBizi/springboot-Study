package com.bizi.spring_study.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//@Component
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求域中的语言参数信息
        String lanuage = request.getParameter("lanuage");
        
        // 获取默认语言参数
        Locale aDefault = Locale.getDefault();
        
        if (StringUtils.isNotEmpty(lanuage)) {
            // zh_CN  语言文化代码和国家地区 zh-HK 华 - 香港的 SARzh-MO 华 - 澳门的 SARzh-CHS 华 (单一化)zh-SG 华 -新加坡zh-TW 华 -台湾zh-CHT 华
            String[] split = lanuage.split("_");
            aDefault = new Locale(split[0],split[1]);
        }

        return aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}
