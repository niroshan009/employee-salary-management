package com.management.salary.employee.model;

import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeModel implements Serializable {

    private String id;
    private String login;
    private String name;
    private String salary;

    public EmployeeModel() {
    }

    public EmployeeModel(String id, String login, String name, String salary) {
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
