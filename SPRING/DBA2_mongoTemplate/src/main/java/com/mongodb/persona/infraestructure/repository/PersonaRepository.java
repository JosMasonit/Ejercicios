package com.mongodb.persona.infraestructure.repository;

import com.mongodb.persona.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {
    List<Persona> findByName(String name);
}
