package com.reto.reto3.controllers;

import com.reto.reto3.dto.ReservationRequest;
import com.reto.reto3.dto.ReservationResponse;
import com.reto.reto3.services.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Reservation")
public class ReservasController {

    private final ReservasService reservasService;

    @Autowired
    public ReservasController(ReservasService reservasService) {
        this.reservasService = reservasService;
    }

    @GetMapping(path = "/all")
    public List<ReservationResponse> getAllReservations() {
        return reservasService.getAllReservas();
    }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveReservation(@RequestBody ReservationRequest reservation) {
        return reservasService.saveReservation(reservation);
    }
    
        @GetMapping("/(id)")
    public Optional<ReservationRequest> getReservation(@PathVariable("id") int idReservation){
        return reservasService.getReservation(idReservation);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationRequest update(@RequestBody ReservationRequest reservation){
        return reservasService.update(reservation);
    }
      
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return reservasService.delete(id);
    }
}
