package com.mongodb.persona.application.usecase;

import com.mongodb.persona.application.port.PersonaPort;
import com.mongodb.persona.domain.Persona;
import com.mongodb.persona.exception.NotFoundException;
import com.mongodb.persona.infraestructure.dto.PersonaInputDTO;
import com.mongodb.persona.infraestructure.dto.PersonaOutputDTO;
import com.mongodb.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaUseCase implements PersonaPort {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO createPersona(PersonaInputDTO personaInputDto) {
        Persona persona = new Persona(personaInputDto);
        mongoTemplate.save(persona);
        return persona.personaToOutput(persona);

    }

    @Override
    public List<PersonaOutputDTO> listaPersonas() {
        List<PersonaOutputDTO> lista = mongoTemplate.findAll(Persona.class).stream().map(p -> p.personaToOutput(p)).toList();
        return lista;
    }

    @Override
    public PersonaOutputDTO deletePersona(String id_persona) throws Exception {
    /*  Persona persona = personaRepository.findById(id_persona).orElseThrow(()->new Exception("Id no encontrada"));
        personaRepository.deleteById(id_persona);
        return persona.personaToOutput(persona); */
        Persona persona;
        if (mongoTemplate.exists(Query.query(Criteria.where("id_persona").is(id_persona)), Persona.class)){
            persona = mongoTemplate.findById(id_persona, Persona.class);
            mongoTemplate.remove(Query.query(Criteria.where("id_persona").is(id_persona)), Persona.class);
            return persona.personaToOutput(persona);
        }
        else throw new NotFoundException("No se ha encontrado la Persona con ID: " + id_persona);
    }

    @Override
    public PersonaOutputDTO updatePersona(String id_persona, PersonaInputDTO personaInputDTO) throws Exception {
    /*  personaRepository.findById(id_persona).orElseThrow(()->new Exception("Id no encontrada"));
        Persona persona = new Persona(personaInputDTO);
        persona.setId_persona(id_persona);
        return persona.personaToOutput(personaRepository.save(persona)); */
        if (mongoTemplate.exists(Query.query(Criteria.where("id_persona").is(id_persona)), Persona.class)) {
            //Persona persona = mongoTemplate.findById(id_persona, Persona.class);
            //persona.update(personaInputDTO);
            Update update = new Update();
            update.set("name", personaInputDTO.name());
            update.set("surname", personaInputDTO.surname());
            update.set("age", personaInputDTO.age());
            mongoTemplate.updateFirst(Query.query(Criteria.where("id_persona").is(id_persona)), update, Persona.class);
            Persona persona = new Persona(personaInputDTO);
            return persona.personaToOutput(persona);
        }

        throw new NotFoundException("No se ha encontrado a la Persona con ID: " + id_persona);
    }

    @Override
    public PersonaOutputDTO findPersona(String id_persona) {
    /*  Persona persona = personaRepository.findById(id_persona).orElseThrow(()->new Exception("Id no encontrada"));
        return persona.personaToOutput(persona); */
        if (mongoTemplate.exists(Query.query(Criteria.where("id_persona").is(id_persona)), Persona.class)){
            Persona persona = mongoTemplate.findById(id_persona, Persona.class);
            return persona.personaToOutput(persona);
        }
        else throw new NotFoundException("No se ha encontrado la Persona con ID: " + id_persona);
    }

    @Override
    public List<PersonaOutputDTO> findPersonaName(String name) {
        List<PersonaOutputDTO> lista = new ArrayList();
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        mongoTemplate.find(query, Persona.class).forEach(p -> lista.add(p.personaToOutput(p)));
        return lista;
    }
}
