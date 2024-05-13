package com.Insa.Employeemanagement.Tenant;

import com.Insa.Employeemanagement.Department.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tenant_name;

    private Long parentId;
    private String address;
    private String contactInfo;
    private String email;
    private String subscription_plan;
    private String industry_type;
    private boolean isInternal;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;


}
