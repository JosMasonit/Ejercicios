package com.mongodb.persona.domain;

import com.mongodb.persona.infraestructure.dto.PersonaInputDTO;
import com.mongodb.persona.infraestructure.dto.PersonaOutputDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persona")
public class Persona {

    @Id
    private String id_persona;

    private String name;

    private String surname;

    private Integer age;

    public Persona(){

    }
    public Persona(PersonaInputDTO personaInputDTO){
        this.name=personaInputDTO.name();
        this.surname=personaInputDTO.surname();
        this.age=personaInputDTO.age();
    }

    public PersonaOutputDTO personaToOutput(Persona persona){
        return new PersonaOutputDTO(persona.getId_persona(), persona.getName(), persona.getSurname(), persona.getAge());
    }

    public String getId_persona() {
        return id_persona;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonaEntity{" +
                "id_persona=" + id_persona +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
