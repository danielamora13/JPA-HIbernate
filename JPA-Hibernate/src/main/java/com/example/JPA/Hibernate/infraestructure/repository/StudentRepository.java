package com.example.JPA.Hibernate.infraestructure.repository;

import com.example.JPA.Hibernate.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentRepository  extends JpaRepository<Student, Integer> {
}
