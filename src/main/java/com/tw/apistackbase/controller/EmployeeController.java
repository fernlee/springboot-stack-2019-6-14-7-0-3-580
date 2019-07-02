package com.tw.apistackbase.controller;

import com.tw.apistackbase.dao.EmployeeDao;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/employees/{id}")
    public ResponseEntity getemployee(@PathVariable("id") int id) {

        Employee employee = employeeDao.findById(id);
        if (employee == null) {
            return new ResponseEntity("No employee found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(employee, HttpStatus.OK);
    }

}
