package com.crud.DB1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepositorio extends JpaRepository<PersonaEntity, Integer> {

    public List<PersonaEntity> findByUsuario(String usuario);
}
