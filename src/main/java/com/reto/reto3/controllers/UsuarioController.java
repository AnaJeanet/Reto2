package com.reto.reto3.controllers;


import com.reto.reto3.entities.Usuario;
import com.reto.reto3.repository.UsuarioCrudRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioCrudRepository usuarioCrudRepository;

    @GetMapping(path = "/usuario")
    private Iterable<Usuario> getUsuarios(){
        return usuarioCrudRepository.findAll();
    }

    @GetMapping(path = "/usuario/{id}")
    private Usuario getUsuariosById(@PathVariable Integer id){
        return usuarioCrudRepository.findById(id).get();
    }

    @GetMapping(path = "/usuario/nombre/{nombre}")
    private Usuario getUsuariosById(@PathVariable String nombre){
        return usuarioCrudRepository.findByNombre(nombre);
    }
    
}
