package com.annotationAndreflectTest.study;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@MyAnnotation(name = "fjl",age = 24,sex = SEX.WOMEN)
public class ReflectPersonTest {
    @FildAnnotation(name="name",len = 16,type = "string")
    private String name;
    @FildAnnotation(name="age",len = 3,type = "int")
    private int age;
    @FildAnnotation(name="id",len = 5,type = "int")
    private int id;
    @FildAnnotation(name="sex",len = 1,type = "string")
    private String sex;
}
