package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.application.PersonaService;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaCreateControlador {

    PersonaService personaService;

    @PostMapping
    public PersonaOutputDto anhadirPersona(@Valid @RequestBody PersonaInputDto per) throws UnprocesableException {
        return personaService.anhadirPersona(per);
    }

}
