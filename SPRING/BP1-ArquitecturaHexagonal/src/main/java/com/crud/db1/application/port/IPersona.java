package com.crud.db1.application.port;

import com.crud.db1.infraestructure.dto.PersonaInputDTO;
import com.crud.db1.infraestructure.dto.PersonaOutputDTO;

import java.util.List;

public interface IPersona {
    PersonaOutputDTO actualizar(Integer id, PersonaInputDTO personaIDTO) throws Exception;
    PersonaOutputDTO addPersona(PersonaInputDTO personaIDTO) throws Exception;
    List<PersonaOutputDTO> getAll();
    PersonaOutputDTO findByID(int id) throws Exception;
    List<PersonaOutputDTO> findByUsuario(String usuario);
    PersonaOutputDTO borrarPersona(int id) throws Exception;
}
