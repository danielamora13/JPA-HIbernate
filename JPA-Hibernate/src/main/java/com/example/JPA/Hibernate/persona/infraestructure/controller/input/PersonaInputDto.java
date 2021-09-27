package com.example.JPA.Hibernate.persona.infraestructure.controller.input;

import com.example.JPA.Hibernate.persona.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDto {
    public String user;
    public String password;
    public String name;
    public String surname;
    public String company_email;
    public String personal_email;
    public String city;
    public Boolean active;
    public Date created_date;
    public String imagen_url;
    public Date termination_date;

    public Persona personaInputDto(){
        Persona persona= new Persona();
        persona.setUser(this.getUser());
        persona.setPassword(this.getPassword());
        persona.setName(this.getName());
        persona.setSurname(this.getSurname());
        persona.setCompany_email(this.getCompany_email());
        persona.setPersonal_email(this.getPersonal_email());
        persona.setCity(this.getCity());
        persona.setActive(this.getActive());
        persona.setCreated_date(this.getCreated_date());
        persona.setImagen_url(this.getImagen_url());
        persona.setTermination_date(this.getTermination_date());
        return persona;
    }
}
