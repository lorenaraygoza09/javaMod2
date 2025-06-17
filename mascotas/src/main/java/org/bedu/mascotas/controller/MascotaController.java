package org.bedu.mascotas.controller;

import org.bedu.mascotas.model.Mascota;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class MascotaController {

    private List<Mascota> baseDatos = new LinkedList<>();
    //CRUD: Create, Read, Delete, Update
    /*
    cuando hacemos un CRUD se usan los metodos HTTP para
    representar las operaciones
    get;obtener, leer
    post; subir, publicar
    put; actualizar
    delete; eliminar

    los nombres de las URL deben ser sustantivos
    //obtenerCarro -> /carros
    //crearCarro -> /carros
     */
    // obtener todas las mascotas
    @GetMapping("/mascotas")
    public List<Mascota> obtener(){
        return baseDatos;
    }

    //agregar una nueva mascota
    /*
    es una buena practica que el endpoint que se encarga de
    crear cosas, regrese lo que creo
     */
    @PostMapping("/mascotas")
    public Mascota agregar(@RequestBody Mascota nuevaMascota){
     baseDatos.add(nuevaMascota);
     return nuevaMascota;
    }
}
