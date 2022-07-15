package com.ciudades.ciudades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador2 {

    @Autowired
    CiudadService ciudades;

    @GetMapping("/controlador2/getCiudad")
    public String getControlador2(){
        return String.valueOf(ciudades.getListaCiudades());
    }

}
