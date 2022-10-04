package com.reto.reto3.controllers;

import com.reto.reto3.dto.Message;
import com.reto.reto3.dto.Motorcycle;
import com.reto.reto3.repository.MensajesRepository;
import com.reto.reto3.services.MensajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Message")
public class MensajeController {
    private final MensajesService mensajesService;

    @Autowired
    public MensajeController(MensajesService mensajesService) {
        this.mensajesService = mensajesService;
    }

    @GetMapping(path = "/all")
    public List<Message> getAllMessages(){
        return mensajesService.getAllMessages();
    }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMoto(@RequestBody Message message){
        mensajesService.saveMoto(message);
    }

}
