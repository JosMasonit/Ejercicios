package com.crud.db1.infraestructure.controller;

import com.crud.db1.infraestructure.dto.PersonaInputDTO;
import com.crud.db1.infraestructure.dto.PersonaOutputDTO;
import com.crud.db1.application.usecase.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorPersona1 {

    @Autowired
    PersonaService personaService;

    @GetMapping("/get")
    public List<PersonaOutputDTO> listarUsuarios(){
        return personaService.getAll();
    }
    @GetMapping("/getID/{id}")
    public PersonaOutputDTO buscarID(@PathVariable int id) throws Exception {
        return personaService.findByID(id);
    }
    @GetMapping("/getUsuario/{usuario}")
    public List<PersonaOutputDTO> buscarUsuario(@PathVariable String usuario) throws Exception {
        return personaService.findByUsuario(usuario);
    }

    @PostMapping("/addPersona")
    public PersonaOutputDTO crearPersona(@RequestBody PersonaInputDTO persona) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.addPersona(persona);
        return personaOutputDTO;
    }

    @PutMapping("/update/{id}")
    public PersonaOutputDTO actualizarPersona(@PathVariable int id, @RequestBody PersonaInputDTO personaIDTO) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.actualizar(id, personaIDTO);
        return personaOutputDTO;
    }

    @DeleteMapping("delete/{id}")
    public PersonaOutputDTO borrarByID(@PathVariable int id) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.borrarPersona(id);
        return personaOutputDTO;
    }

    @GetMapping("/ok")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>(HttpStatus.OK + ": Respuesta estándar para peticiones correctas.", HttpStatus.OK);
    }
    @GetMapping("/teapot")
    ResponseEntity<String> teaPot() {
        return new ResponseEntity<>("ERROR: " + HttpStatus.I_AM_A_TEAPOT, HttpStatus.I_AM_A_TEAPOT);
    }
    @GetMapping("/headers")
    ResponseEntity<String> hello2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Hello", "World!");
        headers.add("Web", "javadesde0.com");

        return new ResponseEntity<>(
                "Mensaje de la descripción", headers, HttpStatus.OK);
    }



   // @Transactional(propagation = Propagation.NOT_SUPPORTED)

}
