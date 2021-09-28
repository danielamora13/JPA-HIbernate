package com.example.JPA.Hibernate.estudianteAsignatura.application;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.EstudianteAsignatura;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.EstudianteAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.EstudianteAsignaturaOutputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.repository.EstudianteAsignaturaRepository;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.student.domain.Estudiante;
import com.example.JPA.Hibernate.student.infraestructure.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService {

    EstudianteAsignaturaInputDto estudianteAsignaturaInputDto = new EstudianteAsignaturaInputDto();

    @Autowired
    EstudianteAsignaturaRepository estudianteAsignaturaRepository;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public EstudianteAsignaturaInputDto getAsignatura() {
        return estudianteAsignaturaInputDto;
    }

    @Override
    public EstudianteAsignaturaOutputDto anhadirAsignatura(EstudianteAsignaturaInputDto estudianteAsignaturaInputDto)
            throws UnprocesableException, NotFoundException {
        if (estudianteAsignaturaInputDto == null) {
            return null;
        }
        if (estudianteAsignaturaInputDto.initialDate == null) {
            throw new UnprocesableException("Alguno de los campos necesarios está vacío");
        }

        EstudianteAsignatura estudianteAsignatura = estudianteAsignaturaInputDto.estudianteAsignaturaInputDto();

        if (!estudianteAsignaturaInputDto.idEstudiantes.isEmpty()) {
            List<String> estudiantes = estudianteAsignaturaInputDto.getIdEstudiantes();
            List<Estudiante> estudiantesCompletos = estudiantes.stream().map(l ->
                    estudianteRepository.findById(l).orElseThrow(() ->
                            new NotFoundException("Estudiante con id "+ l +" no encontrado")))
                    .collect(Collectors.toList());

            estudianteAsignatura.setEstudiantes(estudiantesCompletos);
        }

        estudianteAsignaturaRepository.save(estudianteAsignatura);

        return new EstudianteAsignaturaOutputDto(estudianteAsignatura);
    }

    @Override
    public EstudianteAsignaturaOutputDto updateAsignaturaById(EstudianteAsignaturaInputDto estudianteAsignaturaInputDto,
                                                              String id)
            throws NotFoundException, UnprocesableException {
        if (estudianteAsignaturaInputDto == null) {
            return null;
        }

        EstudianteAsignatura estudianteAsignatura = estudianteAsignaturaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Asignatura con id "+id+" no encontrada"));

        estudianteAsignatura.setEstudianteAsignatura(estudianteAsignaturaInputDto);

        if (!estudianteAsignaturaInputDto.idEstudiantes.isEmpty()) {
            List<String> estudiantes = estudianteAsignaturaInputDto.getIdEstudiantes();

            List<Estudiante> estudiantesCompletos = estudiantes.stream().map(l -> estudianteRepository
                    .findById(l).orElseThrow(() ->
                    new NotFoundException("Estudiante con id "+ l +" no encontrado"))).collect(Collectors.toList());

            estudianteAsignatura.getEstudiantes().addAll(estudiantesCompletos);
        }

        estudianteAsignaturaRepository.save(estudianteAsignatura);

        return new EstudianteAsignaturaOutputDto(estudianteAsignatura);
    }

    @Override
    public EstudianteAsignaturaOutputDto getAsignaturaById(String id) throws NotFoundException {
        return new EstudianteAsignaturaOutputDto(estudianteAsignaturaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Asignatura con id "+id+" no encontrada")));
    }

    @Override
    public List<EstudianteAsignaturaOutputDto> getAsignaturas() {
        List<EstudianteAsignatura> asignaturas = estudianteAsignaturaRepository.findAll();
        return asignaturas.stream().map(EstudianteAsignaturaOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) throws NotFoundException, UnprocesableException {
        EstudianteAsignatura estudianteAsignatura = estudianteAsignaturaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Asignatura con id "+id+" no encontrada"));

        if (estudianteAsignatura.getEstudiantes() != null) {
            throw new UnprocesableException("No se puede borrar la asignatura porque tiene estudiantes asignados.");
        }
        estudianteAsignaturaRepository.deleteById(id);
    }
}
