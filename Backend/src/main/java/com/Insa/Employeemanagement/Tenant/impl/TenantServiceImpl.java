package com.Insa.Employeemanagement.Tenant.impl;


import com.Insa.Employeemanagement.Tenant.Tenant;
import com.Insa.Employeemanagement.Tenant.TenantRepository;
import com.Insa.Employeemanagement.Tenant.TenantService;
import com.Insa.Employeemanagement.Tenant.dto.TenantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TenantServiceImpl implements TenantService {

    TenantRepository tenantRepository;
    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }



    @Override
    public List<TenantDTO> findAll() {
        List<Tenant> tenants = tenantRepository.findAll();
        return tenants.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addTenant(TenantDTO tenantDTO) {
        Tenant tenant = convertToEntity(tenantDTO);
        tenantRepository.save(tenant);

    }

    @Override
    public TenantDTO getTenantById(Long id) {
        Optional<Tenant> tenantOptional= tenantRepository.findById(id);
        return tenantOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public boolean deleteTenant(Long id) {
        try {
            tenantRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean updateTenant(Long id, TenantDTO updatedTenant) {
        Optional<Tenant> tenantOptional = tenantRepository.findById(id);
        if (tenantOptional.isPresent()){
            Tenant tenant = tenantOptional.get();
            updatedTenantFields(tenant,updatedTenant);
            tenantRepository.save(tenant);
            return true;
        }
        return false;
    }


    private TenantDTO convertToDTO(Tenant tenant){
        TenantDTO tenantDTO = new TenantDTO();
        tenant.setTenant_name(tenantDTO.getTenant_name());
        tenant.setEmail(tenantDTO.getEmail());
        tenant.setAddress(tenantDTO.getAddress());
        tenant.setContactInfo(tenantDTO.getContactInfo());
        tenant.setSubscription_plan(tenant.getSubscription_plan());
        tenant.setIndustry_type(tenantDTO.getIndustryType());
        return tenantDTO;
    }

    private Tenant convertToEntity(TenantDTO tenantDTO){
        Tenant tenant = new Tenant();
        tenant.setTenant_name(tenantDTO.getTenant_name());
        tenant.setEmail(tenantDTO.getEmail());
        tenant.setAddress(tenantDTO.getAddress());
        tenant.setContactInfo(tenantDTO.getContactInfo());
        tenant.setSubscription_plan(tenantDTO.getSubscriptionPlan());
        tenant.setIndustry_type(tenantDTO.getIndustryType());
        return tenant;

    }

    private void updatedTenantFields(Tenant tenant, TenantDTO updatedTenant) {
        tenant.setTenant_name(updatedTenant.getTenant_name());
        tenant.setEmail(updatedTenant.getEmail());
        tenant.setAddress(updatedTenant.getAddress());
        tenant.setContactInfo(updatedTenant.getContactInfo());
        tenant.setSubscription_plan(updatedTenant.getSubscriptionPlan());
        tenant.setIndustry_type(updatedTenant.getIndustryType());
    }
}
