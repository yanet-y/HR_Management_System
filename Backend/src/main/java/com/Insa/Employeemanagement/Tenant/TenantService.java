package com.Insa.Employeemanagement.Tenant;

import com.Insa.Employeemanagement.Tenant.dto.TenantDTO;

import java.util.List;

public interface TenantService {
    List<TenantDTO> findAll();

    void addTenant(TenantDTO tenantDTO);

    TenantDTO getTenantById(Long id);

    boolean deleteTenant(Long id);

    boolean updateTenant(Long id, TenantDTO updatedTenant);
}
