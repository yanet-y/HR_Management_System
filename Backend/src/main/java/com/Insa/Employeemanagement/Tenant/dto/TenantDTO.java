package com.Insa.Employeemanagement.Tenant.dto;

import lombok.Data;

@Data
public class TenantDTO {
    private String tenant_name;
    private String address;
    private String contactInfo;
    private String email;
    private String subscriptionPlan;
    private String industryType;
    
}

