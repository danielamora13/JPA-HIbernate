package com.example.JPA.Hibernate.estudianteAsignatura.domain;

import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.StudentAsignaturaInputDto;
import com.example.JPA.Hibernate.student.domain.Student;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class StudentAsignatura {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name ="idStudent")
    private Student student;

    private String asignatura;

    private String comments;

    @Column(nullable = false)
    private Date initialDate;

    private Date finishDate;

    public StudentAsignatura(StudentAsignaturaInputDto studentAsignaturaInputDto) {
        setStudentAsignatura(studentAsignaturaInputDto);
    }

    public void setStudentAsignatura(StudentAsignaturaInputDto studentAsignaturaInputDto) {
        if (studentAsignaturaInputDto == null) {
            return;
        }

        if (studentAsignaturaInputDto.asignatura != null) {
            this.asignatura = studentAsignaturaInputDto.asignatura;
        }

        if (studentAsignaturaInputDto.comments != null) {
            this.comments = studentAsignaturaInputDto.comments;
        }

        if (studentAsignaturaInputDto.initialDate != null) {
            this.initialDate = studentAsignaturaInputDto.initialDate;
        }

        if (studentAsignaturaInputDto.finishDate != null) {
            this.finishDate = studentAsignaturaInputDto.finishDate;
        }
    }
}
