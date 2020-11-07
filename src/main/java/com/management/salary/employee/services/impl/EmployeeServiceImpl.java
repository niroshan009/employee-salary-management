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
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    MapperFacade mapperFacade;

    @Override
    public Iterable<Employee> saveEmployee(MultipartFile file) {
        Iterable<Employee> savedEmployees = null;
        BufferedReader br;

        List<Employee> employeeList = new ArrayList<>();
        try {
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            AtomicInteger index = new AtomicInteger();
            br.lines().forEach(line -> {
                if (index.get() == 0) {
                    index.getAndIncrement();
                    return;
                } else if (!line.startsWith("#")) {
                    index.getAndIncrement();
                    String[] employeeData = line.split(",");
                    Employee employee = new Employee();
                    employee.setId(employeeData[0]);
                    employee.setLogin(employeeData[1]);
                    employee.setName(employeeData[2]);
                    employee.setSalary(new BigDecimal(employeeData[3]));
                    employeeList.add(employee);
                }
            });
            savedEmployees = employeeRepository.saveAll(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
