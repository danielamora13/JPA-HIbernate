package com.example.JPA.Hibernate.student.infraestructure.controller.input;


import com.example.JPA.Hibernate.student.domain.Student;
import lombok.Data;

@Data
public class StudentInputDto {

    public String idStudent;
    public String idPersona;
    public int numHoursWeek;
    public String comments;
    public String idProfesor;
    public String branch;

    public Student studentInputDto() {
        Student student = new Student();
        student.setIdStudent(this.idStudent);
        //s.setPersona(this.idPersona);
        student.setNumHoursWeek(this.numHoursWeek);
        student.setComments(this.comments);
        //s.idProfesor(this.idProfesor);
        student.setBranch(this.branch);
        return student;
    }
}
