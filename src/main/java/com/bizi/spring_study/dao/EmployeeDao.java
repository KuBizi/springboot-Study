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
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Getter
@Setter
@ConfigurationProperties(value = "employeedao")  // 语法绑定要加getter、setter
public class EmployeeDao {
    
    private Map<Integer, Employee> employeeMap;
    
    @Autowired
    private DepartmentDao departmentDao;
    
    // 
    private static AtomicInteger initId =  new AtomicInteger(103);
    private Integer getInitId() {
        return initId.getAndIncrement();
    }
    public Collection<Employee> getEmployees() {
        return employeeMap.values();
    }

    public Employee getEmployeeByIds(Integer id) {
        return employeeMap.get(id);
    }
    
    public void save (Employee employee) {
        if (employee == null) {
            return;
        }
        if (employee.getId() == null) {
            employee.setId(getInitId());
        }
        employee.setDepartment(departmentDao.getDepartmentByIds(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
}
