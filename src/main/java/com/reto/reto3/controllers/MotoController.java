package com.reto.reto3.controllers;

import com.reto.reto3.dto.Motorcycle;
import com.reto.reto3.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    
        @GetMapping("/(id)")
    public Optional<Motorcycle> getMotorbike(@PathVariable("id") int idMoto){
        return motoService.getMotorbike(idMoto);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorcycle update(@RequestBody Motorcycle motorbike){
        return motoService.update(motorbike);
    }
        
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return motoService.delete(id);
    }

}
