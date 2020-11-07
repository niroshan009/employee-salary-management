package com.management.salary.employee.services;

import com.management.salary.employee.entity.Employee;
import com.management.salary.employee.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    public Iterable<Employee> saveEmployee(List<EmployeeModel> employeeModels);
}
