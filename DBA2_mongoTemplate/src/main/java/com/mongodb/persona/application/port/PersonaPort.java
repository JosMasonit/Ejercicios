package com.mongodb.persona.application.port;

import com.mongodb.persona.infraestructure.dto.PersonaInputDTO;
import com.mongodb.persona.infraestructure.dto.PersonaOutputDTO;

import java.util.List;

public interface PersonaPort {
    PersonaOutputDTO createPersona(PersonaInputDTO personaInputDTO);
    List<PersonaOutputDTO> listaPersonas();
    PersonaOutputDTO deletePersona(String id_persona) throws Exception;
    PersonaOutputDTO updatePersona(String id_persona, PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO findPersona(String id_persona) throws Exception;
    List<PersonaOutputDTO> findPersonaName(String name);
}
