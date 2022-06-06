package com.bizi.spring_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration // https://www.jianshu.com/p/23afaf36cfa1
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 页面跳转  如果需要访问一个页面，必须要写Controller类，然后再写一个方法跳转到页面，感觉好麻烦，其实重写WebMvcConfigurer中的addViewControllers方法即可达到效果了
     * @param registry registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("index.html").setViewName("index");
    }

    
    // 为什么使用bean 而不是使用@Component 为么国际化要注册在mvcconfig中
    // 如果想将第三方的类变成组件，你又没有没有源代码，也就没办法使用@Component进行自动配置，
    // 这种时候使用@Bean就比较合适了。不过同样的也可以通过xml方式来定义。
    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
