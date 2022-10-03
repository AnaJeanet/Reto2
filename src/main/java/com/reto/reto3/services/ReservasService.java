package com.reto.reto3.services;

import com.reto.reto3.dto.*;
import com.reto.reto3.entities.*;
import com.reto.reto3.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservasService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservasService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reservation> getAllReservas(){
        List<Reservation> response = new ArrayList<>();
        Iterable<Reserva> reservas = reservaRepository.findAll();
        for (Reserva reserva : reservas) {
            Reservation reservation = new Reservation();
            reservation.setIdReservation(reserva.getId());
            reservation.setStartDate(reserva.getFechaInicio());
            reservation.setDevolutionDate(reserva.getFechaEntrega());
            if (reserva.getIdEstadoReserva() != null) {
                reservation.setStatus(reserva.getIdEstadoReserva().getDescripcion());
            }
            Cliente cliente = reserva.getIdCliente();
            Client client = new Client();
            if (cliente != null) {
                client.setIdClient(cliente.getId());
                client.setEmail(cliente.getCorreo());
                client.setPassword(cliente.getContraseña());
                client.setName(cliente.getNombre());
                client.setAge(cliente.getEdad());
            }
            reservation.setClient(client);
            reservation.setScore(reserva.getScore());

            Motocicleta moto = reserva.getIdMotocicleta();
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.setId(motorcycle.getId());
            motorcycle.setBrand(moto.getMarca());
            motorcycle.setDescription(moto.getDescripcion());
            motorcycle.setYear(moto.getAnio());
            motorcycle.setName(moto.getNombre());
            Categoria categoria = moto.getIdCategoria();
            Category category = new Category();
            category.setId(categoria.getId());
            category.setDescription(categoria.getDescripcion());
            category.setName(categoria.getNombre());
            motorcycle.setCategory(category);
            List<Message> messageList = new ArrayList<>();
            for (Mensaje mensaje : moto.getMensajes()) {
                Message message = new Message();
                message.setIdMessage(mensaje.getId());
                message.setMessageText(mensaje.getTexto());
                messageList.add(message);
            }
            motorcycle.setMessages(messageList);
            reservation.setMotorbike(motorcycle);



            response.add(reservation);
        }

        return response;
    }
}
