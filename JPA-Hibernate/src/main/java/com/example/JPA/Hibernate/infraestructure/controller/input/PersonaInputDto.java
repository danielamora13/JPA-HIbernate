package com.example.JPA.Hibernate.infraestructure.controller.input;

import com.example.JPA.Hibernate.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDto {
    public Integer id;
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
