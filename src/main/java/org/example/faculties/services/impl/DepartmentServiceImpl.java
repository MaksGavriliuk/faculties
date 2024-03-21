package org.example.faculties.services.impl;


import lombok.AllArgsConstructor;
import org.example.faculties.dtos.DepartmentDTO;
import org.example.faculties.entities.Department;
import org.example.faculties.exceptions.NotFoundException;
import org.example.faculties.mappers.DepartmentMapper;
import org.example.faculties.repositories.DepartmentRepository;
import org.example.faculties.services.DepartmentService;
import org.example.faculties.services.FacultyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final FacultyService facultyService;
    private final DepartmentMapper departmentMapper;


    @Override
    public Page<DepartmentDTO> findDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable)
                .map(departmentMapper::toDepartmentDTO);
    }

    @Override
    public Department findDepartmentById(long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти кафедру с id = " + id));
    }

    @Override
    public void deleteDepartmentById(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        facultyService.findFacultyById(departmentDTO.facultyId());
        Department department = departmentMapper.toDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDepartmentDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(long id, DepartmentDTO departmentDTO) {
        facultyService.findFacultyById(departmentDTO.facultyId());
        Department department = departmentMapper
                .toDepartment(departmentDTO)
                .setId(findDepartmentById(id).getId());
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDepartmentDTO(savedDepartment);
    }
    
}