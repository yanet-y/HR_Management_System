package com.Insa.Employeemanagement.Department;

import com.Insa.Employeemanagement.Employee.Employee;
import com.Insa.Employeemanagement.Tenant.Tenant;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
    private String department_name;
    private Integer number_of_employees;
    private String location;
    private String department_type;
    private String region;
    private Date established_date;
    private String mission;
    private String vision;
    private String values;

    @OneToMany
    private List<Employee> employees;




}

