package com.example.JPA.Hibernate.estudianteAsignatura.domain;

import com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.EstudianteAsignaturaInputDto;
import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class EstudianteAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura_seq")
    @GenericGenerator(
            name = "asignatura_seq",
            strategy = "com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Asignatura_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String id;

    @ManyToMany
    @JoinTable(
            name ="idEstudiante",
            joinColumns = @JoinColumn(name = "idEstudiante"),
            inverseJoinColumns = @JoinColumn(name = "idAsignatura")
    )
    private List<Estudiante> estudiantes;

    private String asignatura;

    private String comments;

    @Column(nullable = false)
    private Date initialDate;

    private Date finishDate;

    public EstudianteAsignatura(EstudianteAsignaturaInputDto estudianteAsignaturaInputDto) {
        setEstudianteAsignatura(estudianteAsignaturaInputDto);
    }

    public void setEstudianteAsignatura(EstudianteAsignaturaInputDto estudianteAsignaturaInputDto) {
        if (estudianteAsignaturaInputDto == null) {
            return;
        }

        if (estudianteAsignaturaInputDto.asignatura != null) {
            this.asignatura = estudianteAsignaturaInputDto.asignatura;
        }

        if (estudianteAsignaturaInputDto.comments != null) {
            this.comments = estudianteAsignaturaInputDto.comments;
        }

        if (estudianteAsignaturaInputDto.initialDate != null) {
            this.initialDate = estudianteAsignaturaInputDto.initialDate;
        }

        if (estudianteAsignaturaInputDto.finishDate != null) {
            this.finishDate = estudianteAsignaturaInputDto.finishDate;
        }
    }
}
