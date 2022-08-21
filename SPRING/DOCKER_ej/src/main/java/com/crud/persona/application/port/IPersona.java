package com.crud.persona.application.port;

import com.crud.persona.infraestructure.dto.PersonaInputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputFullDTO;

import java.util.List;

public interface IPersona {
    PersonaOutputDTO actualizar(String id, PersonaInputDTO personaIDTO) throws Exception;
    PersonaOutputDTO addPersona(PersonaInputDTO personaIDTO) throws Exception;
    List<PersonaOutputDTO> getAll();
    List<PersonaOutputFullDTO> getAllFull(String outputType);
    PersonaOutputDTO findByID(String id) throws Exception;
    PersonaOutputFullDTO findByIDFull(String id, String outputType) throws Exception;
    List<PersonaOutputDTO> findByUsuario(String usuario);
    List<PersonaOutputFullDTO> findByUsuarioFull(String usuario, String outputType);
    PersonaOutputDTO borrarPersona(String id) throws Exception;
}
