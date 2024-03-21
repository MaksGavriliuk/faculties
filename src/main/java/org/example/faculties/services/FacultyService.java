package org.example.faculties.services;

import org.example.faculties.dtos.FacultyDTO;
import org.example.faculties.entities.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FacultyService {

    Page<FacultyDTO> findFaculties(Pageable pageable);

    Faculty findFacultyById(long id);

    FacultyDTO getFacultyDTOById(long id);

    void deleteFacultyById(long id);

    FacultyDTO saveFaculty(FacultyDTO facultyDTO);

    FacultyDTO updateFaculty(long id, FacultyDTO facultyDTO);

}