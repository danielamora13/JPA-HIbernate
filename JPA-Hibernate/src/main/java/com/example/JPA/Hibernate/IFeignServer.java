package com.example.JPA.Hibernate;

import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8081/")
public interface IFeignServer {

    @GetMapping("profesor/{id}")
    ResponseEntity<ProfesorOutputDto> callProfesor(@PathVariable("id") String id);
}
