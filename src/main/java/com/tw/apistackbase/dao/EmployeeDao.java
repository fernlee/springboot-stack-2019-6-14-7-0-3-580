package com.tw.apistackbase.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yeli on 2019/7/2.
 */

@Component
public class EmployeeDao {
    private List<Employee> employees;

    public EmployeeDao() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String fileName = "employee.json";
            ClassLoader classLoader = EmployeeDao.class.getClassLoader();
            employees = objectMapper.readValue(new File(classLoader.getResource(fileName).getFile()), new TypeReference<List<Employee>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee add(Employee employee) {
        employee.setId(employees.size());
        employees.add(employee);
        return employee;
    }

    public Object delete(int id) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                return employee;
            }
        }

        return null;
    }

    public Employee update(int id, Employee newEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setId(newEmployee.getId());
                employee.setName(newEmployee.getName());
                employee.setAge(newEmployee.getAge());
                employee.setGender(newEmployee.getGender());
                return newEmployee;
            }
        }
        return null;
    }
}
