package com.crud.crud;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;

public interface PersonaService {

    String getNombre();
    int getEdad();
    String getCiudad();

    void setNombre(String nombre);

    void setEdad(int edad);
    void setCiudad(String ciudad);


    public Persona getPersona();
    public void setPersona(Persona persona);
    public ArrayList<Persona> getListaPersonas();

    public void setListaPersonas(ArrayList<Persona> listaPersonas);

    public void actualizaLista(ObjectNode persona, String id);
}
