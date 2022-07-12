package com.example.demo;

import Dto.Persona;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController()
public class Controlador1 {

    @GetMapping("/user/{name}")
    public String getHola(@PathVariable String name){
        return "Hola " + name;
    }

    /*
    @RequestMapping(path="/useradd")
    public String getUser(@RequestBody ObjectNode request) {
        Persona Person = new Persona(request.get("name").asText(), request.get("edad").asInt(), request.get("ciudad").asText());
        Person.setEdad(Person.getEdad()+1);
        return String.valueOf(Person+"BIEN");
    } */

    String Personaa;
    @PostMapping(path="/useradd")
    public String getUser(@RequestBody ObjectNode request) {
        Persona Person = new Persona(request.get("name").asText(), request.get("edad").asInt(), request.get("ciudad").asText());
        Person.setEdad(Person.getEdad()+1);
        Personaa=String.valueOf(Person);
        return Personaa+"BIEN";
    }
    @GetMapping("/useradd")
    public String getPersona(){
        return Personaa;
    }

    /*
    @RequestMapping(value="/useradd", method = RequestMethod.POST, produces = "text/html", consumes = "application/json")
    public String getData(@RequestBody Persona p){
        p.setEdad(p.getEdad()+1);
        return String.valueOf(p+"bien");
    } */

    @GetMapping("/a")
    public String getHola(){
        return "Hola Mundo";
    }
}
