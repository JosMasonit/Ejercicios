package com.example.demo;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;

    @GetMapping("/controlador1/addPersona")
    public String addPersona(@RequestHeader("Persona") String[] list){

        personaService.setNombre(list[0]);
        personaService.setPoblacion(list[1]);
        personaService.setEdad(Integer.parseInt(list[2]));
        return "OK";
    }
}
