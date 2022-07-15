package com.ciudades.ciudades;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador1 {

    @Autowired
    CiudadService ciudades;

    @PostMapping("/controlador1/addCiudad")
    public String getUser(@RequestBody ObjectNode request) {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(request.get("nombre").asText());
        ciudad.setNumeroHabitantes(request.get("habitantes").asInt());
        (ciudades.getListaCiudades()).add(ciudad);
        return (ciudades.getListaCiudades()).get(0).toString();
    }
}
