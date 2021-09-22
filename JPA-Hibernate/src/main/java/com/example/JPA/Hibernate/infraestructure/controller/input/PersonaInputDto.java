package com.example.JPA.Hibernate.infraestructure.controller.input;

import com.example.JPA.Hibernate.domain.Persona;
import lombok.Data;

@Data
public class PersonaInputDto {
    Integer id;
    String user;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    String created_date;
    String imagen_url;
    String termination_date;

    public Persona personaInputDto(){
        Persona p= new Persona();
        p.setUser(this.getUser());
        p.setPassword(this.getPassword());
        p.setName(this.getName());
        p.setSurname(this.getSurname());
        p.setCompany_email(this.getCompany_email());
        p.setPersonal_email(this.getPersonal_email());
        p.setCity(this.getCity());
        p.setActive(this.getActive());
        p.setCreated_date(this.getCreated_date());
        p.setImagen_url(this.getImagen_url());
        p.setTermination_date(this.getTermination_date());
        return p;
    }
}
