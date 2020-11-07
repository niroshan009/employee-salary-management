package com.management.salary.employee.services.impl;

import com.management.salary.employee.entity.Employee;
import com.management.salary.employee.model.EmployeeModel;
import com.management.salary.employee.repository.EmployeeRepository;
import com.management.salary.employee.services.EmployeeService;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    MapperFacade mapperFacade;

    @Override
    public Iterable<Employee> saveEmployee(List<EmployeeModel> employeeModels) {
        List<Employee> employeeList = mapperFacade.mapAsList(employeeModels, Employee.class);
        Iterable<Employee> savedEmployees = employeeRepository.saveAll(employeeList);
        return savedEmployees;
    }
}
