package com.example.JPA.Hibernate.student.infraestructure.repository;

import com.example.JPA.Hibernate.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentRepository  extends JpaRepository<Student, String> {
}
