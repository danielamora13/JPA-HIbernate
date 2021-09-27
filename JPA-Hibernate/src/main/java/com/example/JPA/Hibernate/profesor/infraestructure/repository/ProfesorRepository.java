package com.example.JPA.Hibernate.profesor.infraestructure.repository;

import com.example.JPA.Hibernate.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProfesorRepository   extends JpaRepository<Profesor, String> {
}
