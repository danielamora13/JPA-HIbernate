package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.application.PersonaService;
import com.example.JPA.Hibernate.application.StudentService;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.StudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/create")
public class CreateControlador {

    PersonaService personaService;
    StudentService studentService;

    @PostMapping("/persona")
    public PersonaOutputDto anhadirPersona(@Valid @RequestBody PersonaInputDto per) throws UnprocesableException {
        return personaService.anhadirPersona(per);
    }

    @PostMapping("/student")
    public StudentOutputDto anhadirStudent(@Valid @RequestBody StudentInputDto s) throws UnprocesableException {
        return studentService.anhadirStudent(s);
    }
}
