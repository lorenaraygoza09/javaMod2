package org.bedu.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller; transmite datos y paginas web (mas viejo)
//@RestController; solo transmite datos (actual)

//un controlador es un conjunto de endpoints
@RestController
public class MiPrimerController {

    //definiendo un endpoint con ruta helloworld
    //para comunicarse con este endpoint se debe enviar
    //una peticion a "http://localhost:8080/helloworld"
    @RequestMapping("/helloworld")

    public String helloWorld(){
        return "Hello world";
    }
}
