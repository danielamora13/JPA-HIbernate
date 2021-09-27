package com.example.JPA.Hibernate.profesor.domain;

import com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    @GenericGenerator(
            name = "profesor_seq",
            strategy = "com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Profesor_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String idProfesor;

    @JoinColumn(name = "id_persona")
    @OneToOne(fetch = FetchType.LAZY)
    private Persona persona;

    private String comments;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes;

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
