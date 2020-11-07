package com.management.salary.employee.repository;

import com.management.salary.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query(value = "SELECT * FROM employee WHERE salary BETWEEN ?1 AND ?2 ",
            countQuery = "SELECT COUNT(*) FROM employee WHERE salary BETWEEN ?1 AND ?2 ",
            nativeQuery = true)
    Page<Employee> filterUser(int minSalary, int maxSalary, Pageable pageable);
}
