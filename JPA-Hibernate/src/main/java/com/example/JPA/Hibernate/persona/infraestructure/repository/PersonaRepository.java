package com.example.JPA.Hibernate.persona.infraestructure.repository;

import com.example.JPA.Hibernate.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaRepository extends JpaRepository<Persona, String> {
    List<Persona> findByName(String name);

    //Persona updatePersonaById (int id, Persona per);


}
