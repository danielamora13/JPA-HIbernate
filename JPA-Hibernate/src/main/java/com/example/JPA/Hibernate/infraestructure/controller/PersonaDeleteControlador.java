package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.application.PersonaService;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaDeleteControlador {

    //@Autowired
    PersonaService personaService;

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) throws NotFoundException {
        personaService.deleteById(id);
    }

}
