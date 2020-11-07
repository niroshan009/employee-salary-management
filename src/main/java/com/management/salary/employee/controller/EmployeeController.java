package com.management.salary.employee.controller;

import com.management.salary.employee.entity.Employee;
import com.management.salary.employee.model.EmployeeModel;
import com.management.salary.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Iterable<Employee> savedEmployees = employeeSerive.saveEmployee(employeeList);
        if(savedEmployees.iterator().hasNext()) {
          responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> fetchEmployees(@RequestParam int minSalary, @RequestParam int maxSalary,
                                                              @RequestParam int offset, @RequestParam int limit,
                                                              @RequestParam String sort) {
        List<EmployeeModel> employeeModelList = employeeSerive.getEmployeeList(minSalary, maxSalary, offset, limit, sort);
        ResponseEntity<List<EmployeeModel>> responseEntity = new ResponseEntity<>(employeeModelList, HttpStatus.OK);
        return responseEntity;
    }

}
