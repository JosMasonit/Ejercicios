package com.crud.persona.infraestructure.repository;

import com.crud.persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepositorio extends JpaRepository<PersonaEntity, String> {

    public List<PersonaEntity> findByUsuario(String usuario);
}
