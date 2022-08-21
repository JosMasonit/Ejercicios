package com.crud.jva2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepositorio extends JpaRepository<PersonaEntity, Integer> {

    public List<PersonaEntity> findByUsuario(String usuario);

    public List<PersonaEntity> getData(HashMap<String, Object> conditions);

}
