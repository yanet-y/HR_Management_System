package com.Insa.Employeemanagement.Tenant;

import com.Insa.Employeemanagement.Tenant.dto.TenantDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/tenants")
public class TenantController {
    private TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public ResponseEntity<List<TenantDTO>> findAll(){

        return ResponseEntity.ok(tenantService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addTenant(@RequestBody TenantDTO tenantDTO){
        tenantService.addTenant(tenantDTO);
        return new ResponseEntity<>("Tenant Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantDTO> getTenantById(@PathVariable Long id){
        TenantDTO tenantDTO = tenantService.getTenantById(id);
        if (tenantDTO != null)
            return new ResponseEntity<>(tenantDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTenant(@PathVariable Long id){
        boolean deleted = tenantService.deleteTenant(id);
        if (deleted)
            return new ResponseEntity<>("Tenant Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTenant(@PathVariable Long id,@RequestBody TenantDTO updatedTenant){
        boolean updated = tenantService.updateTenant(id,updatedTenant);
        if (updated)
            return new ResponseEntity<>("Tenant Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
