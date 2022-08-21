package com.crud.estudiante.infraestructure.repository;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    StudentEntity findByIdPersona(PersonaEntity personaEntity);
}
