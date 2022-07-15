package com.ciudades.ciudades;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CiudadServiceImpl implements CiudadService{
    Ciudad ciudad = new Ciudad();
    ArrayList<Ciudad> listaCiudades = new ArrayList();
    public String getNombre(){
       return ciudad.getNombre();
    }
    public int getNumeroHabitantes(){
        return ciudad.getNumeroHabitantes();
    }

    public void setNombre(String nombre){
        ciudad.setNombre(nombre);
    }
    public void setNumeroHabitantes(int habitantes){
        ciudad.setNumeroHabitantes(habitantes);
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }
}
