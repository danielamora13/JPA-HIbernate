package com.example.JPA.Hibernate.student.infraestructure.controller.output;

import com.example.JPA.Hibernate.student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class StudentOutputDto {
    String idStudent;
    int numHoursWeek;
    String comments;

    public StudentOutputDto(Student student) {
        if (student == null) {
            return;
        }
        this.setIdStudent(student.getIdStudent());
        this.setNumHoursWeek(student.getNumHoursWeek());
        this.setComments(student.getComments());
    }
}
