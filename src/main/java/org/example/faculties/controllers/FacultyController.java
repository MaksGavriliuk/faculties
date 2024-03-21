package org.example.faculties.controllers;

import lombok.AllArgsConstructor;
import org.example.faculties.dtos.FacultyDTO;
import org.example.faculties.services.FacultyService;
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
@RequestMapping("/faculties")
@AllArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<FacultyDTO> getFaculties(Pageable pageable) {
        return facultyService.findFaculties(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FacultyDTO getFacultyById(@PathVariable long id) {
        return facultyService.getFacultyDTOById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FacultyDTO createFaculty(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.saveFaculty(facultyDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FacultyDTO updateFaculty(
            @PathVariable long id,
            @RequestBody FacultyDTO facultyDTO
    ) {
        return facultyService.updateFaculty(id, facultyDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFaculty(@PathVariable long id) {
        facultyService.deleteFacultyById(id);
    }

}