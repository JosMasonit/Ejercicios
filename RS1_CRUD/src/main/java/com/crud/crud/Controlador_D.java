package com.crud.crud;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador_D {

    @Autowired
    PersonaService personas;

    @RequestMapping(value="/persona/{id}", method = RequestMethod.DELETE)
    public void deletePersona(@PathVariable String id){
        personas.getListaPersonas().remove(Integer.parseInt(id));
    }
}
