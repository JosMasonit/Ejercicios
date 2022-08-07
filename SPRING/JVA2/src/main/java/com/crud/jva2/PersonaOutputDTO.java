package com.crud.jva2;

import lombok.Data;

import java.util.Date;


public record PersonaOutputDTO(int id_persona, String usuario, String password, String name, String surname,
String company_email, String personal_email, String city, Boolean active, Date created_date, String imagen_url,
Date termination_date) {

    public static PersonaOutputDTO nuevaPersonaOutputDTO(PersonaEntity persona){
        return new PersonaOutputDTO(persona.getId_persona(), persona.getUsuario(), persona.getPassword(),
                persona.getName(), persona.getSurname(), persona.getCompany_email(), persona.getPersonal_email(),
                persona.getCity(), persona.getActive(), persona.getCreated_date(), persona.getImagen_url(),
                persona.getTermination_date());
    }
}
