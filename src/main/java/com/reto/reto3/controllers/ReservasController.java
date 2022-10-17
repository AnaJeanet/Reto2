package com.reto.reto3.controllers;

import com.reto.reto3.dto.Motorcycle;
import com.reto.reto3.dto.ReservationRequest;
import com.reto.reto3.dto.ReservationResponse;
import com.reto.reto3.services.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteReservation(@PathVariable Integer id){
        return reservasService.deleteById(id);
    }

    @PutMapping(path = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean updateReservation(@RequestBody ReservationRequest reservation){
        return reservasService.updateReserva(reservation);
    }
}
