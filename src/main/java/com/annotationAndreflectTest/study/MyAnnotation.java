package com.annotationAndreflectTest.study;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    
    // 注解参数 ： 参数类型+参数名（）
    String name();
    int age();
    SEX sex();
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
 enum SEX{
    MEN("男",12),
    WOMEN("女",13);
    private String name;
    private int age;
}
