package com.crud.DB1;

public interface IPersona {
    PersonaOutputDTO actualizar(Integer id, PersonaInputDTO personaIDTO) throws Exception;
    PersonaOutputDTO addPersona(PersonaInputDTO personaIDTO) throws Exception;
}
