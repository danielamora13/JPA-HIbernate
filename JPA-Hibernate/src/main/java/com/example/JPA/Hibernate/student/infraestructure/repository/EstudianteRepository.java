package com.example.JPA.Hibernate.student.infraestructure.repository;

import com.example.JPA.Hibernate.student.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}
