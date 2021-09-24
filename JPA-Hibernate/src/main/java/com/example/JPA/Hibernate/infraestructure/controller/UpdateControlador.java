package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.application.PersonaService;
import com.example.JPA.Hibernate.application.StudentService;
import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.StudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/update")
public class UpdateControlador {

    PersonaService personaService;
    StudentService studentService;

    @PutMapping("/persona/{id}")
    public PersonaOutputDto updatePersonaById(@Valid @RequestBody PersonaInputDto per, @PathVariable int id) throws Exception{
        return personaService.updatePersonaById(per, id);
    }

    @PutMapping("/student/{id}")
    public StudentOutputDto updateStudentById(@Valid @RequestBody StudentInputDto s, @PathVariable int id) throws Exception{
        return studentService.updateStudentById(s, id);
    }
}
