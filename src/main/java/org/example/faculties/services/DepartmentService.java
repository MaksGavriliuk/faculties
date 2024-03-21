package org.example.faculties.services;

import org.example.faculties.dtos.DepartmentDTO;
import org.example.faculties.entities.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DepartmentService {

    Page<DepartmentDTO> findDepartments(Pageable pageable);

    Department findDepartmentById(long id);

    void deleteDepartmentById(long id);

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO updateDepartment(long id, DepartmentDTO departmentDTO);

    Page<DepartmentDTO> findDepartmentsByFacultyName(String facultyName, Pageable pageable);

}