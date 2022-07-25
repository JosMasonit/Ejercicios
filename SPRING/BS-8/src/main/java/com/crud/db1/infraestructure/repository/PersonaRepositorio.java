package com.crud.db1.infraestructure.repository;

import com.crud.db1.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepositorio extends JpaRepository<PersonaEntity, Integer> {

    public List<PersonaEntity> findByUsuario(String usuario);
}
