package com.management.salary.employee.entity;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
public class Employee {

    private int id;
    private String login;
    private String name;
    @Digits(integer=10, fraction=2)
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(int id, String login, String name, @Digits(integer = 5, fraction = 2) BigDecimal salary) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
