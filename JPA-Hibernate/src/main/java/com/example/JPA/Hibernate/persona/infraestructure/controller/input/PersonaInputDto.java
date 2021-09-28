package com.example.JPA.Hibernate.persona.infraestructure.controller.input;

import com.example.JPA.Hibernate.persona.domain.Persona;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PersonaInputDto {
    @NotNull(message = "user no puede ser nulo")
    @Size(min = 6, max = 10)
    public String user;

    @NotNull(message = "contraseña no puede ser nula")
    public String password;

    @NotNull(message = "nombre no puede ser nulo")
    public String name;

    public String surname;

    @NotNull(message = "company_email no puede ser nulo")
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    public String company_email;

    @NotNull(message = "personal_email no puede ser nulo")
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    public String personal_email;

    @NotNull(message = "city no puede ser nula")
    public String city;

    @NotNull(message = "active no puede ser nulo")
    public Boolean active;

    @NotNull(message = "created_date no puede ser nulo")
    public Date created_date = new Date();

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
