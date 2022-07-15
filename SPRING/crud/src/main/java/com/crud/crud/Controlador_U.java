package com.crud.crud;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador_U {

    @Autowired
    PersonaService personas;

    @RequestMapping(value="/persona/{id}", method = RequestMethod.PUT)
    public void addPersona(@RequestBody ObjectNode persona, @PathVariable String id){
        personas.actualizaLista(persona, id);
    }
}
