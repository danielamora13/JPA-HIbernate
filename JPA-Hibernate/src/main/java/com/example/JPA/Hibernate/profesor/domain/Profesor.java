package com.example.JPA.Hibernate.profesor.domain;

import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.JPA.Hibernate.student.domain.Student;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Profesor {

    @Id
    private String idProfesor;

    @JoinColumn(name = "id_persona")
    @OneToOne(fetch = FetchType.LAZY)
    private Persona persona;

    private String comments;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    @Column(nullable = false)
    private String branch;

    public Profesor(ProfesorInputDto profesorInputDto) { setProfesor(profesorInputDto);}

    public void setProfesor(ProfesorInputDto profesorInputDto) {
        if (profesorInputDto == null) {
            return;
        }

        if (profesorInputDto.comments != null) {
            this.comments = profesorInputDto.comments;
        }

        if (profesorInputDto.branch != null) {
            this.branch = profesorInputDto.branch;
        }
    }
}
