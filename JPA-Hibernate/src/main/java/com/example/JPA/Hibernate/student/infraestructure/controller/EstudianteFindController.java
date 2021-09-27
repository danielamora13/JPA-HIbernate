package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.student.application.EstudianteService;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.EstudianteOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("estudiante")
public class EstudianteFindController {
    EstudianteService estudianteService;


    @GetMapping("{id}")
    public EstudianteOutputDto getEstudianteById(@PathVariable String id,
                                              @RequestParam(name = "outputType", defaultValue = "simple") String outputType)
            throws NotFoundException {
        return estudianteService.getEstudianteById(id, outputType);
    }

//    @GetMapping("/student/name/{name}")
//    public List<PersonaOutputDto> getPersonaByName(@PathVariable String name) {
//        return studentService.getStudentByName(name);
//    }

    @GetMapping
    public List<SimpleEstudianteOutputDto> getStudents() {
        return estudianteService.getEstudiantes();
    }

}
