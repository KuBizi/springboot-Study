package com.bizi.spring_study.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Department department;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    public Employee(Integer id, String lastName, String email, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.birth = new Date();
    }
}
