package com.BS5.BS5;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Controlador1 {




    public Controlador1(){
        System.out.println("---MENSAJE SIN EL LOG---");
        log.info("MENSAJE DE PRUEBA DESDE EL Controlador1");
    }



    @Autowired
    PersonaService personaService;

    @PostMapping("/controlador1/addPersona")
    public String addPersona(@RequestBody ObjectNode object){

        personaService.setNombre(object.get("name").asText());
        personaService.setPoblacion(object.get("poblacion").asText());
        personaService.setEdad(Integer.parseInt(object.get("edad").asText()));
        return "OK";
    }

    @GetMapping("/controlador1/getPersona")
    public String getControlador2(){
        personaService.MultiplicaEdad();
        return String.valueOf(personaService);
    }
}
