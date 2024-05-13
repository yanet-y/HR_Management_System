package com.Insa.Employeemanagement.Department;


import com.Insa.Employeemanagement.Department.dto.DepartmentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAllDep(){

        return ResponseEntity.ok(departmentService.findAllDep());

    }

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.addDepartment(departmentDTO);
        return new ResponseEntity<>("Department Added Successfully", HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id){
        DepartmentDTO departmentDTO= departmentService.getDepartmentById(id);
        if (departmentDTO != null)
            return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id){
        boolean deleted = departmentService.deleteDepartmentById(id);
        if (deleted)
            return new ResponseEntity<>("Department Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO updatedDepartment){
        boolean updated = departmentService.updateDepartment(id, updatedDepartment);
        if (updated)
            return new ResponseEntity<>("Department Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
