package com.crud.persona.infraestructure.controller;

import com.crud.persona.application.usecase.PersonaService;
import com.crud.persona.infraestructure.dto.PersonaInputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputFullDTO;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("persona")
public class ControladorPersona1 {

    @Autowired
    PersonaService personaService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("user") String username, @RequestParam("password") String pwd)throws Exception{
        return personaService.login(username, pwd);
    }

    @GetMapping("/getAll")
    public List<PersonaOutputFullDTO> listarUsuarios(@RequestParam(defaultValue = "simple", required = false) String outputType){
        return personaService.getAllFull(outputType);
    }
    @GetMapping("/getID/{id}")
    public PersonaOutputFullDTO buscarID(@PathVariable String id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        return personaService.findByIDFull(id, outputType);
    }

    @GetMapping("/getUsuario/{usuario}")
    public List<PersonaOutputFullDTO> buscarUsuario(@PathVariable String usuario, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        return personaService.findByUsuarioFull(usuario, outputType);
    }

    @PostMapping("/addPersona")
    public PersonaOutputDTO crearPersona(@RequestBody PersonaInputDTO persona) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.addPersona(persona);
        return personaOutputDTO;
    }

    @PutMapping("/update/{id}")
    public PersonaOutputDTO actualizarPersona(@PathVariable String id, @RequestBody PersonaInputDTO personaIDTO) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.actualizar(id, personaIDTO);
        return personaOutputDTO;
    }

    @DeleteMapping("delete/{id}")
    public PersonaOutputDTO borrarByID(@PathVariable String id) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.borrarPersona(id);
        return personaOutputDTO;
    }
    @PostConstruct
    public void doLog() {
        System.out.println("Info message in MyController");
    }


}
