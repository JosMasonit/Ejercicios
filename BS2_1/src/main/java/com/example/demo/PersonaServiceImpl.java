package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    Persona persona = new Persona();

    public String getNombre(){
        return persona.getNombre();
    }

    @Override
    public String getPoblacion() {
        return persona.getPoblacion();
    }

    @Override
    public int getEdad() {
        return persona.getEdad();
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }

    @Override
    public void setPoblacion(String poblacion) {
        persona.setPoblacion(poblacion);
    }

    @Override
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
