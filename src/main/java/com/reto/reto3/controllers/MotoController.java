package com.reto.reto3.controllers;

import com.reto.reto3.dto.Message;
import com.reto.reto3.dto.Motorcycle;
import com.reto.reto3.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Motorbike")
public class MotoController {

    private final MotoService motoService;

    @Autowired
    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping(path = "/all")
    public List<Motorcycle> getAllMotos() {
        return motoService.getAllMotos();
    }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMoto(@RequestBody Motorcycle moto) {
        motoService.saveMoto(moto);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteMoto(@PathVariable Integer id){
        return motoService.deleteById(id);
    }

    @PutMapping(path = "/")
    public String updateMoto(@RequestBody Motorcycle moto){
        return motoService.updateMoto(moto);
    }

}
