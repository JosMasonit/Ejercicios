package com.crud.DB1;

import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("En el Controlador de POST");
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



   // @Transactional(propagation = Propagation.NOT_SUPPORTED)

}
