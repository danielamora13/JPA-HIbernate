package com.example.JPA.Hibernate.infraestructure.controller.output;

import com.example.JPA.Hibernate.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutputDto {
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

    public PersonaOutputDto(Persona per) {
        if (per == null) {
            return;
        }
        this.setId(per.getId());
        this.setUser(per.getUser());
        this.setPassword(per.getPassword());
        this.setName(per.getName());
        this.setSurname(per.getSurname());
        this.setCompany_email(per.getCompany_email());
        this.setPersonal_email(per.getPersonal_email());
        this.setCity(per.getCity());
        this.setActive(per.getActive());
        this.setCreated_date(per.getCreated_date());
        this.setImagen_url(per.getImagen_url());
        this.setTermination_date(per.getTermination_date());
    }
}
