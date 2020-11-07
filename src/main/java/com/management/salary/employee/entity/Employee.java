package com.management.salary.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Employee implements Serializable {

    @Id
    private String id;
    private String login;
    private String name;
    @Digits(integer=10, fraction=2)
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String id, String login, String name, @Digits(integer = 10, fraction = 2) BigDecimal salary) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
