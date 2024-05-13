package com.Insa.Employeemanagement.Tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface TenantRepository extends JpaRepository<Tenant,Long>{
    @Query("SELECT t FROM Tenant t WHERE t.tenant_name = ?1")
    Optional<Tenant> findByName(String tenantName);
}


