package com.BS5.BS5;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{
    Persona persona = new Persona();

    public String getNombre(){
        return persona.getNombre();
    }

    public String getPoblacion() {
        return persona.getPoblacion();
    }

    public int getEdad() {
        return persona.getEdad();
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }

    public void setPoblacion(String poblacion) {
        persona.setPoblacion(poblacion);
    }

    public void setEdad(int edad) {
        persona.setEdad(edad);
    }

    public void MultiplicaEdad(){
        persona.setEdad(persona.getEdad()*2);
    }

    @Override
    public String toString() {
        return "PersonaServiceImpl{" +
                "persona=" + persona +
                '}';
    }
}
