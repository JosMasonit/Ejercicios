package com.bs4.BS4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {


    @GetMapping("/valores")
    public String getVariables(@Value("${VAR1:no_existe_VAR1}") String var1, @Value("${My.VAR2:no_existe_VAR2}") String var2){
        return "valor de var1 es: "+var1+ ", valor de my.var2 es: "+var2;
    }


    @GetMapping("/var3")
    public String getVar3(@Value("${VAR3}") String var3){
        return "valor de var3 es: "+var3;
    }
}
