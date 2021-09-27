package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.EstudianteAsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("estudianteAsignatura")
public class EstudianteAsignaturaDeleteController {

    EstudianteAsignaturaService estudianteAsignaturaService;
}
