package com.ejercicio3.ejercicio3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bean1")
public class PersonaServiceImpl1 implements PersonaService{

    Persona p = new Persona();
    public String getNombre() {
        return p.getNombre();
    }
    public void setNombre() {
        String nombre = "bean1";
        p.setNombre(nombre);
    }

}
