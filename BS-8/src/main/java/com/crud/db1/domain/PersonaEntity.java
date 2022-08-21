package com.crud.db1.domain;

import com.crud.db1.infraestructure.dto.PersonaInputDTO;
import com.crud.db1.infraestructure.exceptions.UnprocesableException;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Data
@NamedQuery(name = "PersonaEntity.findByUsuario",
        query = "select p from PersonaEntity p where p.usuario = ?1")

public class PersonaEntity {

    @Id
    @GeneratedValue
    private int id_persona;
    @Column(name="usuario")
    @NotBlank(message = "usuario is mandatory")
    @Size(min = 6, max = 10)
    private String usuario;
    @Column
    @NotBlank(message = "password is mandatory")
    private String password;
    @Column
    @NotBlank(message = "name is mandatory")
    private String name;
    @Column(name="apellidos")
    private String surname;
    @Column
    @NotBlank(message = "company_email is mandatory")
    private String company_email;
    @Column
    @NotBlank(message = "personal_email is mandatory")
    private String personal_email;
    @Column
    @NotBlank(message = "city is mandatory")
    private String city;
    @Column
    @NonNull
    //@NotBlank(message = "active is mandatory") Da error?
    private Boolean active;
    @Column
    @NonNull
    //@NotBlank(message = "created_date is mandatory") Da error?
    private Date created_date;
    @Column
    private String imagen_url;
    @Column
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
        if(persona.getUsuario()!=null && persona.getUsuario().length()<=10 && persona.getUsuario().length()>=6){
            this.usuario=persona.getUsuario();
        }else{
            throw new UnprocesableException("Faltan campos o estos no cumplen los requisitos");
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
