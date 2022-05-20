package com.bizi.spring_study;

import com.bizi.spring_study.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringStudyApplicationTests {

    @Autowired
    private Student stu;
    @Test
    void contextLoads() {
        System.out.println(stu.getAge());
    }

}
