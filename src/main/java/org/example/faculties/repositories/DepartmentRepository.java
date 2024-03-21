package org.example.faculties.repositories;

import org.example.faculties.entities.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Page<Department> findDepartmentsByFacultyName(String facultyName, Pageable pageable);

}