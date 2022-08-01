package com.crud.profesor.infraestructure.repository;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.domain.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity, String> {
    ProfesorEntity findByIdPersona(PersonaEntity personaEntity);
}
