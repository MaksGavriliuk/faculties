package org.example.faculties.controllers;

import lombok.AllArgsConstructor;
import org.example.faculties.dtos.DepartmentDTO;
import org.example.faculties.services.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<DepartmentDTO> getDepartments(Pageable pageable) {
        return departmentService.findDepartments(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO getDepartmentById(@PathVariable long id) {
        return departmentService.getDepartmentDTOById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.saveDepartment(departmentDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO updateDepartment(
            @PathVariable long id,
            @RequestBody DepartmentDTO departmentDTO
    ) {
        return departmentService.updateDepartment(id, departmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartmentById(id);
    }

    @GetMapping("/faculty/{facultyName}")
    public Page<DepartmentDTO> getDepartmentsByFacultyName(
            @PathVariable String facultyName,
            Pageable pageable
    ) {
        return departmentService.findDepartmentsByFacultyName(facultyName, pageable);
    }

}