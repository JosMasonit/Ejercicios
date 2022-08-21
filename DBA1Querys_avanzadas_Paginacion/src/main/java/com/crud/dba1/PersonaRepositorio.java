package com.crud.dba1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepositorio extends JpaRepository<PersonaEntity, Integer> {

    public List<PersonaEntity> findByUsuario(String usuario);

    public Page<PersonaEntity> getData(HashMap<String, Object> conditions, Pageable pageable);

}
