package com.management.salary.employee.services;

import com.management.salary.employee.entity.Employee;
import com.management.salary.employee.model.EmployeeModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface EmployeeService {

    public Iterable<Employee> saveEmployee(List<EmployeeModel> employeeModels);

    public List<EmployeeModel> getEmployeeList(int minSalary, int maxSalary, int offset, int limit, String sort);
}
