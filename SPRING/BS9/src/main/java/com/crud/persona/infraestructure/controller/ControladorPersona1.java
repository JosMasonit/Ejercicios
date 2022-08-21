package com.crud.persona.infraestructure.controller;

import com.crud.persona.application.port.FeignPersonaPort;
import com.crud.persona.application.usecase.PersonaService;
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
@RequestMapping("persona")
public class ControladorPersona1 {


    //@RestControler("/profesor/{id}")
    /*
    @GetMapping("/profesor/{id}")
    public ProfesorOutputDTO getProfesor(@PathVariable String id){
        System.out.println("LLAMADA a ControladorProfesor buscarId");
        String url = "http://localhost:8080/profesor/getID/" + id;
        ResponseEntity<ProfesorOutputDTO> responseEntity = new RestTemplate().getForEntity(url, ProfesorOutputDTO.class);
        System.out.println("RECIBIDO en getProfesor RestTemplate");
        if(responseEntity.getStatusCode() == HttpStatus.OK)
            return responseEntity.getBody();
        else
            throw new RuntimeException("HttpStatus INCORRECTO");
    } */

    @Autowired
    FeignPersonaPort feignPersonaPort;
    @GetMapping("/profesor/{code}")
    public ResponseEntity<ProfesorOutputDTO> callServerByFeign(@PathVariable(name = "code") String code) {
        ResponseEntity<ProfesorOutputDTO> personaOutputDTOResponseEntity = feignPersonaPort.callServer(code);
        return personaOutputDTOResponseEntity;
    }

    @Autowired
    PersonaService personaService;

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

    /*
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
*/


   // @Transactional(propagation = Propagation.NOT_SUPPORTED)

}
