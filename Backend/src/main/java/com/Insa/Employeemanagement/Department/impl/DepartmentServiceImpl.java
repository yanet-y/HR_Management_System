package com.Insa.Employeemanagement.Department.impl;

import com.Insa.Employeemanagement.Department.Department;
import com.Insa.Employeemanagement.Department.DepartmentRepository;
import com.Insa.Employeemanagement.Department.DepartmentService;
import com.Insa.Employeemanagement.Department.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDTO> findAllDep() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addDepartment(DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        departmentRepository.save(department);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.map(this::convertToDTO).orElse(null);
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        try {
            departmentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateDepartment(Long id, DepartmentDTO updatedDepartment) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            updateDepartmentFields(department, updatedDepartment);
            departmentRepository.save(department);
            return true;
        }
        return false;
    }

    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName(department.getDepartment_name());
        departmentDTO.setDepartmentType(department.getDepartment_type());
        departmentDTO.setRegion(department.getRegion());
        departmentDTO.setEstablishedDate(department.getEstablished_date());
        departmentDTO.setMission(department.getMission());
        departmentDTO.setVision(department.getVision());
        departmentDTO.setValues(department.getValues());
        departmentDTO.setNumberOfEmployees(department.getNumber_of_employees());
        departmentDTO.setLocation(department.getLocation());
        return departmentDTO;
    }

    private Department convertToEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDepartment_name(departmentDTO.getDepartmentName());
        department.setDepartment_type(departmentDTO.getDepartmentType());
        department.setRegion(departmentDTO.getRegion());
        department.setEstablished_date(departmentDTO.getEstablishedDate());
        department.setMission(departmentDTO.getMission());
        department.setVision(department.getVision());
        department.setValues(department.getValues());
        department.setNumber_of_employees(departmentDTO.getNumberOfEmployees());
        department.setLocation(departmentDTO.getLocation());
        return department;
    }

    private void updateDepartmentFields(Department department, DepartmentDTO updatedDepartment) {
        department.setDepartment_name(updatedDepartment.getDepartmentName());
        department.setDepartment_type(updatedDepartment.getDepartmentType());
        department.setRegion(updatedDepartment.getRegion());
        department.setEstablished_date(updatedDepartment.getEstablishedDate());
        department.setMission(updatedDepartment.getMission());
        department.setVision(updatedDepartment.getVision());
        department.setValues(updatedDepartment.getValues());
        department.setNumber_of_employees(updatedDepartment.getNumberOfEmployees());
        department.setLocation(updatedDepartment.getLocation());

    }

}

