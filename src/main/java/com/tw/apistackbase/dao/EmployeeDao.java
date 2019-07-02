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

    public EmployeeDao()  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String fileName = "employee.json";
            ClassLoader classLoader = EmployeeDao.class.getClassLoader();
            employees = objectMapper.readValue(new File(classLoader.getResource(fileName).getFile()), new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
        return employees;
    }
}
