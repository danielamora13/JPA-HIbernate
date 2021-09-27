package com.example.JPA.Hibernate.persona.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.persona.application.PersonaService;
import com.example.JPA.Hibernate.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaCreateController {

    PersonaService personaService;

    @PostMapping
    public PersonaOutputDto anhadirPersona(@Valid @RequestBody PersonaInputDto personaInputDto) throws UnprocesableException {
        return personaService.anhadirPersona(personaInputDto);
    }

}
