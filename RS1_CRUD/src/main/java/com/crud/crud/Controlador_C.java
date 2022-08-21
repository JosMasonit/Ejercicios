package com.crud.crud;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador_C {

    @Autowired
    PersonaService personas;

    @RequestMapping(value="/persona", method = RequestMethod.POST)
    public void addPersona(@RequestBody ObjectNode persona){
        Persona p = new Persona(persona.get("name").asText(), persona.get("edad").asInt(), persona.get("poblacion").asText());
        personas.getListaPersonas().add(p);
    }


/*
    @PostMapping(path="/useradd")
    public String getUser(@RequestBody ObjectNode request) {
        Persona person = new Persona(request.get("name").asText(), request.get("edad").asInt(), request.get("ciudad").asText());
        person.setEdad(person.getEdad()+1);
        user=String.valueOf(person);
        return user;
    }
*/
}
