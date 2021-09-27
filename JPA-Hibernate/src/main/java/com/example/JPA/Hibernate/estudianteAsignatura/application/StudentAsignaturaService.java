package com.example.JPA.Hibernate.estudianteAsignatura.application;

import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.StudentAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.StudentAsignaturaOutputDto;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;


import java.util.List;

public interface StudentAsignaturaService {

    StudentAsignaturaInputDto getAsignatura();

    StudentAsignaturaOutputDto anhadirAsignatura(StudentAsignaturaInputDto studentAsignaturaInputDto) throws UnprocesableException;

    StudentAsignaturaOutputDto updateAsignaturaById(StudentAsignaturaInputDto studentAsignaturaInputDto, String id) throws NotFoundException, UnprocesableException;

    StudentAsignaturaOutputDto getAsignaturaById(String id) throws NotFoundException;

    //List<StudentAsignaturaOutputDto> getAsignaturatByName(String name);

    List<StudentAsignaturaOutputDto> getAsignaturas();

    void deleteById(String id) throws NotFoundException;
}
