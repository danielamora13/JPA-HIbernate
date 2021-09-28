package com.example.JPA.Hibernate.student.domain;

import com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator;
import com.example.JPA.Hibernate.estudianteAsignatura.domain.EstudianteAsignatura;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.EstudianteInputDto;
import lombok.*;
import org.hibernate.annotations.Parameter;
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
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @GenericGenerator(
            name = "student_seq",
            strategy = "com.example.JPA.Hibernate.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "Estudiante_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String idEstudiante;

    @JoinColumn(name = "id_persona")
    @OneToOne(fetch = FetchType.LAZY)
    private Persona persona;

    @Column(nullable = false)
    private int numHoursWeek;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "idProfesor")
    private Profesor profesor;

    @Column(nullable = false)
    private String branch;

    @ManyToMany(mappedBy = "estudiantes")
    private List<EstudianteAsignatura> asignaturas;

    public Estudiante(EstudianteInputDto studentInputDto) { setEstudiante(studentInputDto); }

    public void setEstudiante(EstudianteInputDto estudianteInputDto) {

        if (estudianteInputDto == null) {
            return;
        }

//        if (studentInputDto.persona != null) {
//            this.persona = studentInputDto.persona;
//        }

        if (estudianteInputDto.numHoursWeek != 0) {
            this.numHoursWeek = estudianteInputDto.numHoursWeek;
        }

        if (estudianteInputDto.comments != null) {
            this.comments = estudianteInputDto.comments;
        }

//        if (studentInputDto.idProfesor != null) {
//            this.idProfesor = studentInputDto.idProfesor;
//        }

        if (estudianteInputDto.branch != null) {
            this.branch = estudianteInputDto.branch;
        }
    }

}
