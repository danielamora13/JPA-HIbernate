package com.example.JPA.Hibernate.student.infraestructure.controller.output;

import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.StudentAsignaturaOutputDto;
import com.example.JPA.Hibernate.student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SimpleStudentOutputDto extends StudentOutputDto{

    List<StudentAsignaturaOutputDto> asignaturas;

    public SimpleStudentOutputDto(Student student) {
        super(student);

        if (student.getAsignaturas() != null) {
            this.setAsignaturas(student.getAsignaturas().stream().map(l -> new StudentAsignaturaOutputDto(l)).collect(Collectors.toList()));
        }
    }
}
