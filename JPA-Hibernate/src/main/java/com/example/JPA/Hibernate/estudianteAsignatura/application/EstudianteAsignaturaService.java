package com.example.JPA.Hibernate.estudianteAsignatura.application;

import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.EstudianteAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.EstudianteAsignaturaOutputDto;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;


import java.util.List;

public interface EstudianteAsignaturaService {

    EstudianteAsignaturaInputDto getAsignatura();

    EstudianteAsignaturaOutputDto anhadirAsignatura(EstudianteAsignaturaInputDto estudianteAsignaturaInputDto)
            throws UnprocesableException;

    EstudianteAsignaturaOutputDto updateAsignaturaById(EstudianteAsignaturaInputDto estudianteAsignaturaInputDto,
                                                       String id)
            throws NotFoundException, UnprocesableException;

    EstudianteAsignaturaOutputDto getAsignaturaById(String id)
            throws NotFoundException;

    List<EstudianteAsignaturaOutputDto> getAsignaturas();

    void deleteById(String id)
            throws NotFoundException;
}
