package com.example.JPA.Hibernate.profesor.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.profesor.application.ProfesorService;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("profesor")
public class ProfesorFindController {

    ProfesorService profesorService;

    @GetMapping("{id}")
    public ProfesorOutputDto getProfesorById(@PathVariable String id)
            throws NotFoundException {
        return profesorService.getProfesorById(id);
    }

//    @GetMapping("/profesor/name/{name}")
//    public List<ProfesorOutputDto> getProfesorByName(@PathVariable String name) {
//        return profesorService.getProfesorByName(name);
//    }

    @GetMapping
    public List<ProfesorOutputDto> getProfesors() {
        return profesorService.getProfesors();
    }
}
