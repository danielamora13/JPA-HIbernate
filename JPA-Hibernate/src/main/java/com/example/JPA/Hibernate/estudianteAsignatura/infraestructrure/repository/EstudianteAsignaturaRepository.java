package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.repository;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.EstudianteAsignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

//@Service
public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignatura, String> {
}
