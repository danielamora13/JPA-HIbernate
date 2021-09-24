package com.example.JPA.Hibernate.domain;

import com.example.JPA.Hibernate.infraestructure.controller.input.StudentInputDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int idStudent;

    @JoinColumn(name = "id_persona")
    @OneToOne(fetch = FetchType.LAZY)
    private Persona persona;

    @Column(nullable = false)
    private int numHoursWeek;

    private String comments;

    //private String idProfesor,

    @Column(nullable = false)
    private String branch;

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
