package com.ciudades.ciudades;

import java.util.ArrayList;

public interface CiudadService {
    String getNombre();
    int getNumeroHabitantes();

    void setNombre(String nombre);
    void setNumeroHabitantes(int habitantes);


    public ArrayList<Ciudad> getListaCiudades();

    public void setListaCiudades(ArrayList<Ciudad> listaCiudades);
}
