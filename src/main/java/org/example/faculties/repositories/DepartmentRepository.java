package org.example.faculties.repositories;


import org.example.faculties.entities.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Page<Department> findDepartmentByFacultyName(String facultyName);
}