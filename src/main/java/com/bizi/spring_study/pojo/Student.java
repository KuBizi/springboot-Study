package com.bizi.spring_study.pojo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ConfigurationProperties(value = "student")
//@ConfigurationProperties(value = "student")
public class Student {
    
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private Integer age;
}
// value 是spring 框架
// ConfigurationProperties 是spring boot 框架
// https://blog.csdn.net/qq_40837310/article/details/105960560
