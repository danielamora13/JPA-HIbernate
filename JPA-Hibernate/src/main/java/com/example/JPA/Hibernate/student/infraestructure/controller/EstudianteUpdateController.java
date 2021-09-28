package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.student.application.EstudianteService;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.EstudianteInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("estudiante")
public class EstudianteUpdateController {

    EstudianteService estudianteService;

    @PutMapping("{id}")
    public SimpleEstudianteOutputDto updateEstudianteById(@Valid @RequestBody EstudianteInputDto estudianteInputDto,
                                                          @PathVariable String id)
            throws NotFoundException, UnprocesableException {
        return estudianteService.updateEstudianteById(estudianteInputDto, id);
    }

    @PutMapping("add/{id}")
    public SimpleEstudianteOutputDto asignarAsignaturasAEstudiante(@PathVariable String id,
                                                                   @Valid @RequestBody List<String> asignaturas)
            throws NotFoundException, UnprocesableException {
        return estudianteService.asignarAsignaturasAEstudiante(id, asignaturas);
    }

    @PutMapping("quitar/{id}")
    public SimpleEstudianteOutputDto desasignarAsignaturasAEstudiante(@PathVariable String id,
                                                                      @Valid @RequestBody List<String> asignaturas)
            throws NotFoundException, UnprocesableException {
        return estudianteService.desasignarAsignaturasAEstudiante(id, asignaturas);
    }
}
