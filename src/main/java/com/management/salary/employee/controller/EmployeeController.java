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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String,List<EmployeeModel>>> fetchEmployees(@RequestParam(value ="minSalary",required=true) int minSalary, @RequestParam(value ="maxSalary",required=true) int maxSalary,
                                                                            @RequestParam(value ="offset",required=true) int offset, @RequestParam(value ="limit",required=true) int limit,
                                                                            @RequestParam(value ="sort",required=true) String sort) {
        List<EmployeeModel> employeeModelList = employeeSerive.getEmployeeList(minSalary, maxSalary, offset, limit, sort);
        Map<String,List<EmployeeModel>> responseMap = new HashMap<>();
        responseMap.put("results",employeeModelList);

        ResponseEntity<Map<String,List<EmployeeModel>>> responseEntity = new ResponseEntity<>(responseMap, HttpStatus.OK);

        return responseEntity;
    }

}
