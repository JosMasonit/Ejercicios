package com.crud.db1.application.usecase;

import com.crud.db1.application.port.IPersona;
import com.crud.db1.domain.PersonaEntity;
import com.crud.db1.infraestructure.dto.PersonaInputDTO;
import com.crud.db1.infraestructure.dto.PersonaOutputDTO;
import com.crud.db1.infraestructure.repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersona {

    @Autowired
    PersonaRepositorio personaRepo;

    public PersonaOutputDTO actualizar(Integer id, PersonaInputDTO personaIDTO) throws Exception {
        PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        pEntity.setAll(personaIDTO); //setAll ya se encargar de añadir solo los campos no nulos
        personaRepo.saveAndFlush(pEntity);
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(pEntity);
        return personaOutputDTO;
    }

    public PersonaOutputDTO addPersona(PersonaInputDTO personaIDTO) throws Exception {
        if(personaIDTO.getUsuario().length() < 6 || personaIDTO.getUsuario().length() > 10 || personaIDTO.getUsuario() == null){
            throw new Exception("La longitud del usuario NO ES CORRECTA, debe contener entre 6 y 10 carácteres");
        } else if (personaIDTO.getPassword() == null) {
            throw new Exception("El password no puede ser null");
        } else if (personaIDTO.getName() == null) {
            throw new Exception("name no puede ser null");
        } else if (personaIDTO.getCompany_email() == null) {
            throw new Exception("company_email no puede ser null");
        } else if (personaIDTO.getPersonal_email() == null) {
            throw new Exception("personal_email no puede ser null");
        } else if (personaIDTO.getCity() == null) {
            throw new Exception("city no puede ser null");
        } else if (personaIDTO.getActive() == null) {
            throw new Exception("active no puede ser null, deberá ser true o false");
        } else if (personaIDTO.getCreated_date() == null) {
            throw new Exception("created_date no puede ser null");
        } else{
            PersonaEntity personaEntity = new PersonaEntity(personaIDTO);
            personaRepo.save(personaEntity);
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(personaEntity);
            return saveOutputDTO;
        }
    }

    public List<PersonaOutputDTO> getAll(){
        List<PersonaEntity> listaEntity = personaRepo.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList();
        for(int i=0; i< listaEntity.size(); i++){
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(listaEntity.get(i));
            listaOutput.add(personaOutputDTO);
        }
        return listaOutput;
    }

    public PersonaOutputDTO findByID(int id) throws Exception {
        PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(pEntity);
        return personaOutputDTO;
    }

    public List<PersonaOutputDTO> findByUsuario(String usuario) {
        List<PersonaEntity> listaEntity = personaRepo.findByUsuario(usuario);
        List<PersonaOutputDTO> listaOutput = new ArrayList();
        for(int i=0; i< listaEntity.size(); i++){
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(listaEntity.get(i));
            listaOutput.add(personaOutputDTO);
        }
        return listaOutput;
    }

    public PersonaOutputDTO borrarPersona(int id) throws Exception {
        PersonaEntity pEntity = personaRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(pEntity);
        personaRepo.deleteById(id);
        return personaOutputDTO;
    }

}
