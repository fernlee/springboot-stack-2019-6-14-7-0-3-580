package com.tw.apistackbase.controller;

import com.tw.apistackbase.dao.EmployeeDao;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yeli on 2019/7/2.
 */

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
}
