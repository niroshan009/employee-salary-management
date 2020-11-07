package com.management.salary.employee.controller;

import com.management.salary.employee.entity.Employee;
import com.management.salary.employee.model.EmployeeModel;
import com.management.salary.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("users")
public class EmployeeController {

    @Autowired
    EmployeeService employeeSerive;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadUsers(@RequestBody List<EmployeeModel> employeeList) {
        ResponseEntity<String> responseEntity;
        Iterable<Employee> savedEmployees =  employeeSerive.saveEmployee(employeeList);
        if(savedEmployees.iterator().hasNext()) {
          responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

}
