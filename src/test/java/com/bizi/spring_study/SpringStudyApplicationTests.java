package com.bizi.spring_study;

import com.bizi.spring_study.dao.DepartmentDao;
import com.bizi.spring_study.dao.EmployeeDao;
import com.bizi.spring_study.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringStudyApplicationTests {

    @Autowired
    private Student stu;
    
    @Autowired 
    private DepartmentDao departmentDao;    
    @Autowired 
    private EmployeeDao employeedao;
    @Test
    void contextLoads() {
        System.out.println(stu.getAge());
    }

    @Test
    void contextLoadsdepartmentDao() {
        System.out.println(departmentDao.getDepartmentMap().get(1001));
        System.out.println(employeedao.getEmployeeMap().get(101));
    }

}
