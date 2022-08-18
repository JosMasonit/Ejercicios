package com.mongodb.persona.infraestructure.controller;

import com.mongodb.persona.application.port.PersonaPort;
import com.mongodb.persona.infraestructure.dto.PersonaInputDTO;
import com.mongodb.persona.infraestructure.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
public class ControladorPersona {

    @Autowired
    PersonaPort personaPort;

    @PostMapping
    public PersonaOutputDTO crearPersona(@RequestBody PersonaInputDTO personaInputDTO){
        return personaPort.createPersona(personaInputDTO);
    }

    @GetMapping("/all")
    public List<PersonaOutputDTO> listarPersonas(){
        return personaPort.listaPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDTO> buscarPersona(@PathVariable(name = "id") String id_persona) {
        try {
            return new ResponseEntity<>(personaPort.findPersona(id_persona), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<PersonaOutputDTO> buscarPersonaByName(@PathVariable("name") String name) {
        return personaPort.findPersonaName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDTO> modificarPersona(@PathVariable(name = "id") String id_persona, @RequestBody PersonaInputDTO personaInputDTO) {
        try {
            return new ResponseEntity<>(personaPort.updatePersona(id_persona, personaInputDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PersonaOutputDTO> borrarPersona(@PathVariable(name = "id") String id_persona) {
        try {
            return new ResponseEntity<>(personaPort.deletePersona(id_persona), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }
    }

}
