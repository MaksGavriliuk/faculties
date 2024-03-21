package org.example.faculties.mappers;

import org.example.faculties.dtos.FacultyDTO;
import org.example.faculties.entities.Faculty;
import org.mapstruct.Mapper;


@Mapper
public interface FacultyMapper {

    Faculty toFaculty(FacultyDTO facultyDTO);

    FacultyDTO toFacultyDTO(Faculty faculty);

}