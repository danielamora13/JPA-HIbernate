package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.StudentAsignaturaService;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.StudentAsignaturaOutputDto;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.StudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("studentAsignatura")
public class StudentAsignaturaFindController {

    StudentAsignaturaService studentAsignaturaService;


    @GetMapping("{id}")
    public StudentAsignaturaOutputDto getAsignaturaById(@PathVariable String id)
            throws NotFoundException {
        return studentAsignaturaService.getAsignaturaById(id);


    }

//    @GetMapping("/student/name/{name}")
//    public List<PersonaOutputDto> getPersonaByName(@PathVariable String name) {
//        return studentService.getStudentByName(name);
//    }

    @GetMapping
    public List<StudentAsignaturaOutputDto> getAsignaturas() {
        return studentAsignaturaService.getAsignaturas();
    }

}
