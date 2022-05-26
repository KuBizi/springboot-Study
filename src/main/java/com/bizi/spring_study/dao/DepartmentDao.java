package com.bizi.spring_study.dao;

import com.bizi.spring_study.pojo.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 *  部门dao
 */
@Component
@Getter
@Setter
@ConfigurationProperties(value = "departmentdao")  // 语法绑定要加getter、setter
public class DepartmentDao {
    //@Value("${departmentdao.departmentmap}")  不支持复杂的语法绑定  
    private Map<Integer, Department> departmentMap; 
    
    public Collection<Department> Departments() {
        return departmentMap.values();
    }
    
    public Department getDepartmentByIds(Integer id) {
        return departmentMap.get(id);
    }
}
