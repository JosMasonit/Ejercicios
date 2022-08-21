package com.crud.estudiante_asignatura.infraestructure.repository;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import com.crud.persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteAsignaturaRepository extends JpaRepository<EstudianteAsignaturaEntity, String> {

    List<EstudianteAsignaturaEntity> findByEstudiante(StudentEntity studentEntity);
}
