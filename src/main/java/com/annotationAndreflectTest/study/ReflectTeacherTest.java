package com.annotationAndreflectTest.study;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReflectTeacherTest extends ReflectPersonTest {
    private String school = "zhengxiao";
}
