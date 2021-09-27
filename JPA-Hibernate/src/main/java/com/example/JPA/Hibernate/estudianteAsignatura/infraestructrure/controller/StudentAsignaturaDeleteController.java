package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.StudentAsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("studentAsignatura")
public class StudentAsignaturaDeleteController {

    StudentAsignaturaService studentAsignaturaService;
}
