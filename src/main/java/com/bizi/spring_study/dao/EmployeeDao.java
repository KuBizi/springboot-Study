package com.bizi.spring_study.dao;

import com.bizi.spring_study.pojo.Department;
import com.bizi.spring_study.pojo.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties(value = "employeedao")  // 语法绑定要加getter、setter
public class EmployeeDao {
    
    private Map<Integer, Employee> employeeMap;

    public Collection<Employee> Departments() {
        return employeeMap.values();
    }

    public Employee getDepartmentByIds(Integer id) {
        return employeeMap.get(id);
    }
}
