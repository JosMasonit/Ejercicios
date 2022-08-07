package com.crud.jva2;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NamedQuery(name = "PersonaEntity.findByUsuario",
        query = "select p from PersonaEntity p where p.usuario = ?1")

public class PersonaEntity {

    @Id
    @GeneratedValue
    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public PersonaEntity(){

    }

    public PersonaEntity(PersonaInputDTO personaIDTO){
        if(personaIDTO==null)
            return;
        setId_persona(personaIDTO.getId_persona());
        setUsuario(personaIDTO.getUsuario());
        setPassword(personaIDTO.getPassword());
        setName(personaIDTO.getName());
        setSurname(personaIDTO.getSurname());
        setCompany_email(personaIDTO.getCompany_email());
        setPersonal_email(personaIDTO.getPersonal_email());
        setCity(personaIDTO.getCity());
        setActive(personaIDTO.getActive());
        setCreated_date(personaIDTO.getCreated_date());
        setImagen_url(personaIDTO.getImagen_url());
        setTermination_date(personaIDTO.getTermination_date());
    }

    public void setAll(PersonaInputDTO persona){
        if(persona.getUsuario()!=null){
            this.usuario=persona.getUsuario();
        }
        if(persona.getPassword()!=null){
            this.password=persona.getPassword();
        }
        if(persona.getName()!=null){
            this.name=persona.getName();
        }
        if(persona.getSurname()!=null){
            this.surname=persona.getSurname();
        }
        if(persona.getCompany_email()!=null){
            this.company_email=persona.getCompany_email();
        }
        if(persona.getPersonal_email()!=null){
            this.personal_email=persona.getPersonal_email();
        }
        if(persona.getCity()!=null){
            this.city=persona.getCity();
        }
        if(persona.getActive()!=null){
            this.active=persona.getActive();
        }
        if(persona.getCreated_date()!=null){
            this.created_date=persona.getCreated_date();
        }
        if(persona.getImagen_url()!=null){
            this.imagen_url=persona.getImagen_url();
        }
        if(persona.getTermination_date()!=null){
            this.termination_date=persona.getTermination_date();
        }

    }

    /*
    public void setAll(String usuario, String password, String name, String surname, String company_email, String personal_email,
                       String city, Boolean active, Date created_date, String imagen_url, Date termination_date){
        this.usuario=usuario;
        this.password=password;
        this.name=name;
        this.surname=surname;
        this.company_email=company_email;
        this.personal_email=personal_email;
        this.city=city;
        this.active=active;
        this.created_date=created_date;
        this.imagen_url=imagen_url;
        this.termination_date=termination_date;
    } */
}
