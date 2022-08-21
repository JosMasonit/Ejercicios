package com.crud.crud;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonaServiceImpl implements  PersonaService{
    Persona persona = new Persona();
    ArrayList<Persona> listaPersonas = new ArrayList();

    public String getNombre(){
        return persona.getName();
    }
    public int getEdad(){
        return persona.getEdad();
    }
    public String getCiudad(){
        return persona.getCiudad();
    }

    public void setNombre(String nombre) {
        persona.setName(nombre);
    }
    public void setEdad(int edad){
        persona.setEdad(edad);
    }
    public void setCiudad(String ciudad){
        persona.setCiudad(ciudad);
    }


    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void actualizaLista(ObjectNode persona, String id){
        Persona p = getListaPersonas().get(Integer.parseInt(id));
        if(!persona.get("name").asText().isEmpty()){
            p.setName(persona.get("name").asText());
        }
        if(!persona.get("edad").asText().isEmpty()){
            p.setEdad(persona.get("edad").asInt());
        }
        if(!persona.get("poblacion").asText().isEmpty()){
            p.setCiudad(persona.get("poblacion").asText());
        }
        getListaPersonas().set(Integer.parseInt(id), p);
    }
}
