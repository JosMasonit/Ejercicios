package com.crud.dba1;

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

    @Temporal(TemporalType.DATE)
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public PersonaEntity(){

    }

    public PersonaEntity(PersonaInputDTO personaIDTO){
        if(personaIDTO==null)
            return;
        setId_persona(personaIDTO.id_persona());
        setUsuario(personaIDTO.usuario());
        setPassword(personaIDTO.password());
        setName(personaIDTO.name());
        setSurname(personaIDTO.surname());
        setCompany_email(personaIDTO.company_email());
        setPersonal_email(personaIDTO.personal_email());
        setCity(personaIDTO.city());
        setActive(personaIDTO.active());
        setCreated_date(personaIDTO.created_date());
        setImagen_url(personaIDTO.imagen_url());
        setTermination_date(personaIDTO.termination_date());
    }

    public void setAll(PersonaInputDTO persona){
        if(persona.usuario()!=null){
            this.usuario=persona.usuario();
        }
        if(persona.password()!=null){
            this.password=persona.password();
        }
        if(persona.name()!=null){
            this.name=persona.name();
        }
        if(persona.surname()!=null){
            this.surname=persona.surname();
        }
        if(persona.company_email()!=null){
            this.company_email=persona.company_email();
        }
        if(persona.personal_email()!=null){
            this.personal_email=persona.personal_email();
        }
        if(persona.city()!=null){
            this.city=persona.city();
        }
        if(persona.active()!=null){
            this.active=persona.active();
        }
        if(persona.created_date()!=null){
            this.created_date=persona.created_date();
        }
        if(persona.imagen_url()!=null){
            this.imagen_url=persona.imagen_url();
        }
        if(persona.termination_date()!=null){
            this.termination_date=persona.termination_date();
        }

    }

}
