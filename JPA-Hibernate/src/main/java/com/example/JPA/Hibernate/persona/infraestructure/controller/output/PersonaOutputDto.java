package com.example.JPA.Hibernate.persona.infraestructure.controller.output;

import com.example.JPA.Hibernate.persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaOutputDto {
    String id;
    String user;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;

    public PersonaOutputDto(Persona persona) {
        if (persona == null) {
            return;
        }
        this.setId(persona.getId());
        this.setUser(persona.getUser());
        this.setPassword(persona.getPassword());
        this.setName(persona.getName());
        this.setSurname(persona.getSurname());
        this.setCompany_email(persona.getCompany_email());
        this.setPersonal_email(persona.getPersonal_email());
        this.setCity(persona.getCity());
        this.setActive(persona.getActive());
        this.setCreated_date(persona.getCreated_date());
        this.setImagen_url(persona.getImagen_url());
        this.setTermination_date(persona.getTermination_date());
    }
}
