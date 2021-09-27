package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.student.application.StudentService;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.StudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentFindController {
    StudentService studentService;


    @GetMapping("{id}")
    public StudentOutputDto getStudentById(@PathVariable String id,
                                                 @RequestParam(name = "outputType", defaultValue = "simple") String outputType)
            throws NotFoundException {
//        switch (outputType) {
//            case "simple":
//                return studentService.getSimpleStudentById(id);
//            case "full":
//                return studentService.getFullStudentById(id);
//            default:
//                throw new NotFoundException("outputType no valido");
        return studentService.getStudentById(id, outputType);




    }

//    @GetMapping("/student/name/{name}")
//    public List<PersonaOutputDto> getPersonaByName(@PathVariable String name) {
//        return studentService.getStudentByName(name);
//    }

    @GetMapping
    public List<SimpleStudentOutputDto> getStudents() {
        return studentService.getStudents();
    }

}
