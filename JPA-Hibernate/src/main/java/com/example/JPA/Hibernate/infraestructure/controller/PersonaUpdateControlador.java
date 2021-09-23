package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.application.PersonaService;
import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaUpdateControlador {

    PersonaService personaService;

    @PutMapping("{id}")
    public PersonaOutputDto updatePersonaById(@Valid @RequestBody PersonaInputDto per, @PathVariable int id) throws Exception{
        return personaService.updatePersonaById(per, id);
    }
}
