package com.annotationAndreflectTest.study;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReflectPersonTest {
    private String name;
    private int age;
    private int id;
}
