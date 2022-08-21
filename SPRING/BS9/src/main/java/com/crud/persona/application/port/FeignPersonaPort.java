package com.crud.persona.application.port;

import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8081")
public interface FeignPersonaPort {
    @GetMapping("/profesor/getID/{httpCode}")
    ResponseEntity<ProfesorOutputDTO> callServer(@PathVariable("httpCode") String httpCode);
}