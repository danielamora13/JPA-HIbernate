package com.example.JPA.Hibernate.persona.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaProfesorOutputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaStudentOutputDto;
import com.example.JPA.Hibernate.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    PersonaInputDto personaInputDto = new PersonaInputDto();

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaInputDto getPersona()
    {
        return  personaInputDto;
    }

    /**
     * Metodo para anhadir a un usurario a la tabla persona.
     * @param personaInputDto usuario a anhadir.
     * @return el usuarioi que se ha anhadido.
     * @throws Exception si los email no son validos o no lo es el nombre de usuario.
     */
    public PersonaOutputDto anhadirPersona(PersonaInputDto personaInputDto) throws UnprocesableException {
        if (personaInputDto == null) {
            return null;
        }
        if (!personaInputDto.getCompany_email().contains("@")) {
            throw new UnprocesableException("El email de compañia no es valido");
        }
        if (!personaInputDto.getPersonal_email().contains("@")) {
            throw new UnprocesableException("El email personal no es valido");
        }

        if (personaInputDto.getUser().length() < 6 || personaInputDto.getUser().length() > 10) {
            throw new UnprocesableException("El nombre de usuario no es valido");
        }
        Persona persona = personaInputDto.personaInputDto();

        personaRepository.save(persona);

        return new PersonaOutputDto(persona);
    }

    /**
     * Metodo para actualizar los datos de un usuario en la tabla persona
     * @param personaInputDto datos nuevos del usuario
     * @param id id del usuario a actualizar
     * @return usuario actualizado
     * @throws Exception si los email no son validos o no lo es el nombre de usuario o el usuario
     * con el id no existe.
     */
    public PersonaOutputDto updatePersonaById(PersonaInputDto personaInputDto, String id) throws NotFoundException, UnprocesableException {
        if (personaInputDto == null) {
            return null;
        }
        if (!personaInputDto.getCompany_email().contains("@")) {
            throw new UnprocesableException("El email de compañia no es valido");
        }
        if (!personaInputDto.getPersonal_email().contains("@")) {
            throw new UnprocesableException("El email personal no es valido");
        }
        if (personaInputDto.getUser().length() < 6 || personaInputDto.getUser().length() > 10) {
            throw new UnprocesableException("El nombre de usuario no es valido");
        }
        Persona persona = personaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Usuario con id "+id+" no encontrado"));
        persona.setPersona(personaInputDto);

        personaRepository.save(persona);

        PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);

        return personaOutputDto;

    }

    /**
     * Metodo que encuentra a un usuario dado su id
     * @param id id del usuario a encontrar
     * @return el usuario buscado
     * @throws Exception si no hay ningun usuario con ese id
     */
    public PersonaOutputDto getPersonaById(String id) throws NotFoundException {

        Persona persona = personaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Usuario con id "+id+" no encontrado"));

        if (persona.getProfesor() != null) {
            return new PersonaProfesorOutputDto(persona);
        } else if (persona.getEstudiante() != null) {
            return new PersonaStudentOutputDto(persona);
        } else {
            return new PersonaOutputDto(persona);
        }
    }

    /**
     * Metodo que encuentra a los usuarios dado su nombre
     * @param name nombre de los usuarios a encontrar
     * @return los usuarios buscados
     */
    public List<PersonaOutputDto> getPersonaByName(String name){
        List<Persona> personas = personaRepository.findByName(name);
        return personas.stream().map(l -> new PersonaOutputDto(l)).collect(Collectors.toList());
    }

    /**
     * Metodo que devuelve la lista de usuarios de la tabla persona
     * @return lista de usuarios de la tabla persona
     */
    public List<PersonaOutputDto> getPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().map(PersonaOutputDto::new).collect(
                Collectors.toList());
    }

    /**
     * Metodo que borra a un usuario
     * @param id id del usuario a borrar
     */
    public void deleteById(String id) throws NotFoundException {

        personaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Persona con id "+id+" no encontrada"));

        personaRepository.deleteById(id);
    }



}
