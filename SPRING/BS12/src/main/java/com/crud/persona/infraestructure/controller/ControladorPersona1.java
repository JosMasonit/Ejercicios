package com.crud.persona.infraestructure.controller;

import com.crud.persona.application.port.FeignPersonaPort;
import com.crud.persona.application.usecase.PersonaService;
import com.crud.persona.domain.PersonaEntity;
import com.crud.persona.infraestructure.dto.PersonaInputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputFullDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
//@RequestMapping("persona")
public class ControladorPersona1 {


    @Autowired
    PersonaService personaService;

    @CrossOrigin(origins = "*", methods = RequestMethod.POST )
    @RequestMapping("addperson")
    public PersonaOutputDTO crearPerson(@RequestBody PersonaInputDTO persona) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.addPersona(persona);
        return personaOutputDTO;
    }

    @GetMapping("/getall")
    public List<PersonaOutputFullDTO> listarUsuarios(@RequestParam(defaultValue = "simple", required = false) String outputType){
        return personaService.getAllFull(outputType);
    }
    @GetMapping("/getID/{id}")
    public PersonaOutputFullDTO buscarID(@PathVariable String id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        return personaService.findByIDFull(id, outputType);
    }


}
