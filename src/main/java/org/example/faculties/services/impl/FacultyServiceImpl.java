package org.example.faculties.services.impl;

import lombok.AllArgsConstructor;
import org.example.faculties.dtos.FacultyDTO;
import org.example.faculties.entities.Faculty;
import org.example.faculties.exceptions.NotFoundException;
import org.example.faculties.mappers.FacultyMapper;
import org.example.faculties.repositories.FacultyRepository;
import org.example.faculties.services.FacultyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    @Override
    public Page<FacultyDTO> findFaculties(Pageable pageable) {
        return facultyRepository.findAll(pageable)
                .map(facultyMapper::toFacultyDTO);
    }

    @Override
    public Faculty findFacultyById(long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти факультет с id = " + id));
    }

    @Override
    public FacultyDTO getFacultyDTOById(long id) {
        return facultyMapper.toFacultyDTO(findFacultyById(id));
    }

    @Override
    public void deleteFacultyById(long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public FacultyDTO saveFaculty(FacultyDTO facultyDTO) {
        Faculty savedFaculty = facultyRepository.save(facultyMapper.toFaculty(facultyDTO));
        return facultyMapper.toFacultyDTO(savedFaculty);
    }

    @Override
    public FacultyDTO updateFaculty(long id, FacultyDTO facultyDTO) {
        Faculty faculty = facultyMapper
                .toFaculty(facultyDTO)
                .setId(findFacultyById(id).getId());
        Faculty savedFaculty = facultyRepository.save(faculty);
        return facultyMapper.toFacultyDTO(savedFaculty);
    }

}