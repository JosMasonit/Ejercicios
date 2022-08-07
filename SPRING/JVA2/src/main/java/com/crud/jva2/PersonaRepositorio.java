package com.crud.jva2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<PersonaEntity, Integer> {

    public List<PersonaEntity> findByUsuario(String usuario);
}
