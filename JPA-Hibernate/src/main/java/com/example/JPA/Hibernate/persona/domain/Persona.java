package com.example.JPA.Hibernate.persona.domain;

import com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator;
import com.example.JPA.Hibernate.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import org.hibernate.annotations.Parameter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @GenericGenerator(
            name = "persona_seq",
            strategy = "com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Persona_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String id;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    private String surname;

    @Column(nullable = false)
    private String company_email;

    @Column(nullable = false)
    private String personal_email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Date created_date = new Date();

    private String imagen_url;

    private  Date termination_date;

    @OneToOne(mappedBy = "persona",
              cascade = CascadeType.ALL,
              orphanRemoval = true,
              fetch = FetchType.LAZY
    )
    private Estudiante estudiante;

    @OneToOne(mappedBy = "persona",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Profesor profesor;

    public Persona(PersonaInputDto personaInputDto){
        setPersona(personaInputDto);
    }

    public Persona(String user,
                   String password,
                   String name,
                   String surname,
                   String company_email,
                   String personal_email,
                   String city,
                   Boolean active,
                   Date created_date,
                   String imagen_url,
                   Date termination_date) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
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
