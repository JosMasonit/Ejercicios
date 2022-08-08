package com.crud.dba1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepositorio personaRepo;


    public PersonaOutputDTO actualizar(Integer id, PersonaInputDTO personaIDTO) throws Exception {
        PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new Exception("No encontrado la persona con ID: "+id));
        pEntity.setAll(personaIDTO); //setAll ya se encargar de añadir solo los campos no nulos
        personaRepo.saveAndFlush(pEntity);
        PersonaOutputDTO personaOutputDTO = PersonaOutputDTO.nuevaPersonaOutputDTO(pEntity);
        return personaOutputDTO;
    }

    public PersonaOutputDTO addPersona(PersonaInputDTO personaIDTO) throws Exception {
        if(personaIDTO.usuario().length() < 6 || personaIDTO.usuario().length() > 10 || personaIDTO.usuario() == null){
            throw new Exception("La longitud del usuario NO ES CORRECTA, debe contener entre 6 y 10 carácteres");
        } else if (personaIDTO.password() == null) {
            throw new Exception("El password no puede ser null");
        } else if (personaIDTO.name() == null) {
            throw new Exception("name no puede ser null");
        } else if (personaIDTO.company_email() == null) {
            throw new Exception("company_email no puede ser null");
        } else if (personaIDTO.personal_email() == null) {
            throw new Exception("personal_email no puede ser null");
        } else if (personaIDTO.city() == null) {
            throw new Exception("city no puede ser null");
        } else if (personaIDTO.active() == null) {
            throw new Exception("active no puede ser null, deberá ser true o false");
        } else if (personaIDTO.created_date() == null) {
            throw new Exception("created_date no puede ser null");
        } else{
            PersonaEntity personaEntity = new PersonaEntity(personaIDTO);
            personaRepo.save(personaEntity);
            PersonaOutputDTO saveOutputDTO = PersonaOutputDTO.nuevaPersonaOutputDTO(personaEntity);
            return saveOutputDTO;
        }
    }

    public List<PersonaOutputDTO> getAll(){
        List<PersonaEntity> listaEntity = personaRepo.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList();
        for(int i=0; i< listaEntity.size(); i++){
            PersonaOutputDTO personaOutputDTO = PersonaOutputDTO.nuevaPersonaOutputDTO(listaEntity.get(i));
            listaOutput.add(personaOutputDTO);
        }
        return listaOutput;
    }

    public PersonaOutputDTO findByID(int id) throws Exception {
        PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new Exception("No encontrado la persona con ID: "+id));
        PersonaOutputDTO personaOutputDTO = PersonaOutputDTO.nuevaPersonaOutputDTO(pEntity);
        return personaOutputDTO;
    }

    public List<PersonaOutputDTO> findByUsuario(String usuario) throws Exception {
        List<PersonaEntity> listaEntity = personaRepo.findByUsuario(usuario);
        List<PersonaOutputDTO> listaOutput = new ArrayList();
        for(int i=0; i< listaEntity.size(); i++){
            PersonaOutputDTO personaOutputDTO = PersonaOutputDTO.nuevaPersonaOutputDTO(listaEntity.get(i));
            listaOutput.add(personaOutputDTO);
        }
        return listaOutput;
    }

    public PersonaOutputDTO borrarPersona(int id) throws Exception {
        PersonaEntity pEntity = personaRepo.findById(id).orElseThrow(() -> new Exception("No encontrado la persona con ID: "+id));
        PersonaOutputDTO personaOutputDTO = PersonaOutputDTO.nuevaPersonaOutputDTO(pEntity);
        personaRepo.deleteById(id);
        return personaOutputDTO;
    }

}
