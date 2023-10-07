package com.crud.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "email")
    private String email;


    @Column(name = "empName")
    private String empName;

    public Employee(long id, String empName, String email) {
        super();
        this.id = id;
        this.empName = empName;
        this.email = email;
    }

    public Employee(String empName, String email) {
        super();
        this.empName = empName;
        this.email = email;
    }





    public long getId() {
        return id;
    }

    public Employee() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
