package com.example.JPA.Hibernate.student.domain;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.StudentAsignatura;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.StudentInputDto;
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
public class Student {

    @Id
    private String idStudent;

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

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentAsignatura> asignaturas;

    public Student(StudentInputDto studentInputDto) { setStudent(studentInputDto); }

    public void setStudent(StudentInputDto studentInputDto) {

        if (studentInputDto == null) {
            return;
        }

//        if (studentInputDto.persona != null) {
//            this.persona = studentInputDto.persona;
//        }

        if (studentInputDto.numHoursWeek != 0) {
            this.numHoursWeek = studentInputDto.numHoursWeek;
        }

        if (studentInputDto.comments != null) {
            this.comments = studentInputDto.comments;
        }

//        if (studentInputDto.idProfesor != null) {
//            this.idProfesor = studentInputDto.idProfesor;
//        }

        if (studentInputDto.branch != null) {
            this.branch = studentInputDto.branch;
        }
    }

}
