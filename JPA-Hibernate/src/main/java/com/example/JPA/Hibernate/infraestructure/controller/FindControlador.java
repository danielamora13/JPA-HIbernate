package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.application.PersonaService;
import com.example.JPA.Hibernate.application.StudentService;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.StudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("find")
public class FindControlador {

    PersonaService personaService;
    StudentService studentService;

    @GetMapping("/persona/{id}")
    public PersonaOutputDto getPersonaById(@PathVariable int id) throws NotFoundException {
        return personaService.getPersonaById(id);
    }

    @GetMapping("/persona/name/{name}")
    public List<PersonaOutputDto> getPersonaByName(@PathVariable String name) {
        return personaService.getPersonaByName(name);
    }

    @GetMapping("/persona")
    public List<PersonaOutputDto> getPersonas() {
        return personaService.getPersonas();
    }

    @GetMapping("/student/{id}")
    public StudentOutputDto getStudentById(@PathVariable int id) throws NotFoundException {
        return studentService.getStudentById(id);
    }

//    @GetMapping("/student/name/{name}")
//    public List<PersonaOutputDto> getPersonaByName(@PathVariable String name) {
//        return studentService.getStudentByName(name);
//    }

    @GetMapping("/student")
    public List<StudentOutputDto> getStudents() {
        return studentService.getStudents();
    }

}
