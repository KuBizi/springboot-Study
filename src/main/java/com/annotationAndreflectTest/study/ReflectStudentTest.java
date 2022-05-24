package com.annotationAndreflectTest.study;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReflectStudentTest extends ReflectPersonTest{
private String type = "学生";
}
