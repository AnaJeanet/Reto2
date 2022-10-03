package com.reto.reto3.controllers;

import com.reto.reto3.dto.Reservation;
import com.reto.reto3.services.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Reservation> getAllReservations() {
        return reservasService.getAllReservas();
    }

    @PostMapping(path = "/save")
    public String saveReservation(@RequestBody Reservation reservation) {
        return reservasService.saveReservation(reservation);
    }
}
