package com.example.JPA.Hibernate.domain;

import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false)
    String user;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String name;
    String surname;
    @Column(nullable = false)
    String company_email;
    @Column(nullable = false)
    String personal_email;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    Boolean active;
    @Column(nullable = false, columnDefinition = "date")
    String created_date;
    String imagen_url;
    @Column(columnDefinition = "date")
    String termination_date;

    public Persona(PersonaInputDto personaInputDto){
        setPersona(personaInputDto);
    }

    public void setPersona(PersonaInputDto personaInputDto) {

        if (personaInputDto == null) {
            return;
        }

        if (personaInputDto.user != null) {
            this.user = personaInputDto.user ;
        }

        if (personaInputDto.password != null) {
            this.password = personaInputDto.password ;
        }

        if (personaInputDto.name != null) {
            this.name = personaInputDto.name ;
        }

        if (personaInputDto.surname != null) {
            this.surname = personaInputDto.surname ;
        }

        if (personaInputDto.company_email != null) {
            this.company_email = personaInputDto.company_email ;
        }

        if (personaInputDto.personal_email != null) {
            this.personal_email = personaInputDto.personal_email ;
        }

        if (personaInputDto.city != null) {
            this.city = personaInputDto.city ;
        }

        if (personaInputDto.active != null) {
            this.active = personaInputDto.active ;
        }

        if (personaInputDto.created_date != null) {
            this.created_date = personaInputDto.created_date ;
        }

        if (personaInputDto.imagen_url != null) {
            this.imagen_url = personaInputDto.imagen_url ;
        }

        if (personaInputDto.termination_date != null) {
            this.termination_date = personaInputDto.termination_date ;
        }

    }

}
