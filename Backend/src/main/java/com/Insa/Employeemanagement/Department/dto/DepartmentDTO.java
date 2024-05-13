package com.Insa.Employeemanagement.Department.dto;


import lombok.Data;

import java.util.Date;

@Data
public class DepartmentDTO {
    private Long depId;
    private String departmentName;
    private Integer numberOfEmployees;
    private String location;
    private String departmentType;
    private String region;
    private Date establishedDate;
    private String mission;
    private String vision;
    private String values;


}
