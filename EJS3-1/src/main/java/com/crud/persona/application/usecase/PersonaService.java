package com.crud.persona.application.usecase;

import com.crud.estudiante.application.usecase.ReadEstudianteUseCase;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import com.crud.persona.application.port.IPersona;
import com.crud.persona.domain.PersonaEntity;
import com.crud.persona.infraestructure.dto.*;
import com.crud.comun.exceptions.NotFoundException;
import com.crud.comun.exceptions.UnprocesableException;
import com.crud.persona.infraestructure.repository.PersonaRepositorio;
import com.crud.profesor.application.usecase.ReadProfesorUseCase;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.repository.ProfesorRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersona {

    @Autowired
    PersonaRepositorio personaRepo;

    @Autowired
    ReadEstudianteUseCase readEstudianteUseCase;

    @Autowired
    ReadProfesorUseCase readProfesorUseCase;



    public ResponseEntity<String> login(String user, String password) {
        PersonaEntity userLogin = null;
        if(personaRepo.findByUsuario(user).size() != 0){
            userLogin = personaRepo.findByUsuario(user).get(0);
            if(userLogin.getPassword().equals(password)){
                String rol = (userLogin.getAdmin()) ? "ROLE_ADMIN" : "ROLE_USER";
                return new ResponseEntity<>(getJWTToken(userLogin.getUsuario(), rol), HttpStatus.OK);
            } else return new ResponseEntity<>("Incorrect password. Try again.", HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>(("User " + user + " doesnt exits."), HttpStatus.BAD_REQUEST);
    }
    private String getJWTToken(String user, String rol){
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("id_JWT")
                .setSubject(user)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();

        return "Bearer " + token;
    }


    public PersonaOutputDTO actualizar(String id, PersonaInputDTO personaIDTO) {
        try{
            PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
            pEntity.setAll(personaIDTO); //setAll ya se encargar de añadir solo los campos no nulos
            personaRepo.saveAndFlush(pEntity);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(pEntity);
            return personaOutputDTO;

        }catch(Exception ex){
            throw new UnprocesableException("Los campos no cumplen los requisitos");
        }
    }

    public PersonaOutputDTO addPersona(PersonaInputDTO personaIDTO) {
        try{
            PersonaEntity personaEntity = new PersonaEntity(personaIDTO);
            personaRepo.save(personaEntity);
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(personaEntity);
            return saveOutputDTO;

        }catch(Exception ex){

            throw new UnprocesableException("Faltan campos o estos no cumplen los requisitos");
        }
    }


    public List<PersonaOutputDTO> getAll(){
        List<PersonaEntity> listaEntity = personaRepo.findAll();
        List<PersonaOutputDTO> listaOutput = new ArrayList();
        for(int i=0; i< listaEntity.size(); i++){
            System.out.println(listaEntity.get(i));
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(listaEntity.get(i));
            listaOutput.add(personaOutputDTO);
        }
        return listaOutput;
    }
    public List<PersonaOutputFullDTO> getAllFull(String outputType){
        List<PersonaEntity> listaEntity = personaRepo.findAll();
        List<PersonaOutputFullDTO> listaOutput = new ArrayList();
        if(outputType.equalsIgnoreCase("simple")){
            for(int i=0; i< listaEntity.size(); i++){
                PersonaOutputFullDTO personaOutputFullDTO = new PersonaOutputFullDTO(listaEntity.get(i));
                listaOutput.add((PersonaOutputFullDTO) personaOutputFullDTO);
            }
            return listaOutput;

        }else {
            for(int i=0; i< listaEntity.size(); i++){
                PersonaOutputFullDTO personaOutputFullDTO = FullEstudianteProfesor(listaEntity.get(i));
                listaOutput.add(personaOutputFullDTO);
            }
            return listaOutput;
        }
    }

    public PersonaOutputFullDTO FullEstudianteProfesor(PersonaEntity persona){
        ProfesorEntity posibleProfesor = readProfesorUseCase.findByIdPersona(persona);
        if(posibleProfesor!=null){
            System.out.println("La persona es un profesor");
            PersonaOutputFullDTO personaOutputFullDTO = new PersonaOutputFullDTO(persona, posibleProfesor);
            return personaOutputFullDTO;
        }
        StudentEntity posibleEstudiante = readEstudianteUseCase.findByIdPersona(persona);
        if(posibleEstudiante!=null){
            System.out.println("La persona es un estudiante");
            PersonaOutputFullDTO personaOutputFullDTO = new PersonaOutputFullDTO(persona, posibleEstudiante);
            return personaOutputFullDTO;
        }
        PersonaOutputFullDTO personaOutputFullDTO = new PersonaOutputFullDTO(persona);
        return personaOutputFullDTO;
    }
    public PersonaOutputFullDTO findByIDFull(String id, String outputType) {
        PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        if(outputType.equalsIgnoreCase("simple")){
            PersonaOutputFullDTO personaOutputFullDTO = new PersonaOutputFullDTO(pEntity);
            return personaOutputFullDTO;
        }else{
            //if es estudiante o profesor!!
            PersonaOutputFullDTO personaOutputFullDTO = FullEstudianteProfesor(pEntity);
            return personaOutputFullDTO;
        }
    }
    public PersonaOutputDTO findByID(String id) {
        PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(pEntity);
        return personaOutputDTO;
    }
    public PersonaEntity findByIDentity(String id) {
        PersonaEntity pEntity=personaRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        return pEntity;
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

    public List<PersonaOutputFullDTO> findByUsuarioFull(String usuario, String outputType) {
        List<PersonaEntity> listaEntity = personaRepo.findByUsuario(usuario);
        List<PersonaOutputFullDTO> listaOutput = new ArrayList();
        if(outputType.equalsIgnoreCase("simple")){
            for(int i=0; i< listaEntity.size(); i++){
                PersonaOutputFullDTO personaOutputFullDTO = new PersonaOutputFullDTO(listaEntity.get(i));
                listaOutput.add((PersonaOutputFullDTO) personaOutputFullDTO);
            }
            return listaOutput;

        }else {
            for(int i=0; i< listaEntity.size(); i++){
                PersonaOutputFullDTO personaOutputFullDTO = FullEstudianteProfesor(listaEntity.get(i));
                listaOutput.add(personaOutputFullDTO);
            }
            return listaOutput;
        }
    }

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    StudentRepository studentRepository;
    public PersonaOutputDTO borrarPersona(String id) {
        PersonaEntity pEntity = personaRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        ProfesorEntity profesorEntity= profesorRepository.findByIdPersona(pEntity);
        StudentEntity studentEntity= studentRepository.findByIdPersona(pEntity);

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(pEntity);
        personaRepo.deleteById(id);
        return personaOutputDTO;
    }

}
