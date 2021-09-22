package com.example.JPA.Hibernate.infraestructure.repository;

import com.example.JPA.Hibernate.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByName(String name);

    //Persona updatePersonaById (int id, Persona per);


}
