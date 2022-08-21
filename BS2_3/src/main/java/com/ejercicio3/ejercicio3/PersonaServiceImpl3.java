package com.ejercicio3.ejercicio3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bean3")
public class PersonaServiceImpl3 implements PersonaService{

    Persona p = new Persona();
    public String getNombre() {
        return p.getNombre();
    }
    public void setNombre() {
        String nombre = "bean3";
        p.setNombre(nombre);
    }

}
