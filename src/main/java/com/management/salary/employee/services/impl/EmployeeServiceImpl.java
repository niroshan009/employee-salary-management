package com.management.salary.employee.services.impl;

import com.management.salary.employee.entity.Employee;
import com.management.salary.employee.model.EmployeeModel;
import com.management.salary.employee.repository.EmployeeRepository;
import com.management.salary.employee.services.EmployeeService;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
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

    @Override
    public List<EmployeeModel> getEmployeeList(int minSalary, int maxSalary, int offset, int limit, String sort) {
        char sortOrder = sort.charAt(0);
        String orderColumn = sort.substring(1);
        Sort.Direction order = Sort.Direction.ASC;

        if (sortOrder == '-') {
            order = Sort.Direction.DESC;
        }

        Page<Employee> employees = employeeRepository.filterUser(minSalary, maxSalary,
                PageRequest.of(offset, limit, Sort.by(order, orderColumn)));
        List<EmployeeModel> employeeList = mapperFacade.mapAsList(employees.getContent(), EmployeeModel.class);
        return employeeList;
    }
}
