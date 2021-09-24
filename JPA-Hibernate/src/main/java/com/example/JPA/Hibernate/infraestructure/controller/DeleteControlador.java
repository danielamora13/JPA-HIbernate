package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.application.PersonaService;
import com.example.JPA.Hibernate.application.StudentService;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("delete")
public class DeleteControlador {

    //@Autowired
    PersonaService personaService;
    StudentService studentService;

    @DeleteMapping("/persona/{id}")
    public void deletePersonaById(@PathVariable int id) throws NotFoundException {
        personaService.deleteById(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable int id) throws NotFoundException {
        studentService.deleteById(id);
    }


}
