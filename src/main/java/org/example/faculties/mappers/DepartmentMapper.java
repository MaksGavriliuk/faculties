package org.example.faculties.mappers;


import org.example.faculties.dtos.DepartmentDTO;
import org.example.faculties.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface DepartmentMapper {

    @Mapping(source = "facultyId", target = "faculty.id")
    Department toDepartment(DepartmentDTO departmentDTO);

    @Mapping(source = "faculty.id", target = "facultyId")
    DepartmentDTO toDepartmentDTO(Department department);

}