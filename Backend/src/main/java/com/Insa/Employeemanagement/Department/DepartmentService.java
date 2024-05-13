package com.Insa.Employeemanagement.Department;

import com.Insa.Employeemanagement.Department.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> findAllDep();

    void addDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentById(Long id);

    boolean deleteDepartmentById(Long id);

    boolean updateDepartment(Long id, DepartmentDTO updatedDepartment);
}
