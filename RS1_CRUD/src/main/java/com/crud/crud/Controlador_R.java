package com.crud.crud;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador_R {

    @Autowired
    PersonaService personas;

    @RequestMapping(value="/persona/{id}", method = RequestMethod.GET)
    public String consultaPersona(@PathVariable String id){
        return (personas.getListaPersonas().get(Integer.parseInt(id))).toString();
    }
}
