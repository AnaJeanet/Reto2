package com.reto.reto3.services;

import com.reto.reto3.dto.*;
import com.reto.reto3.entities.*;
import com.reto.reto3.repository.ClienteRepository;
import com.reto.reto3.repository.EstadoReservaRepository;
import com.reto.reto3.repository.MotosCrudRepository;
import com.reto.reto3.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {

    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final MotosCrudRepository motoRepository;
    private final EstadoReservaRepository estadoReservaRepository;

    @Autowired
    public ReservasService(ReservaRepository reservaRepository, ClienteRepository clienteRepository,
                           MotosCrudRepository motoRepository,
                           EstadoReservaRepository estadoReservaRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.motoRepository = motoRepository;
        this.estadoReservaRepository = estadoReservaRepository;
    }

    public List<ReservationResponse> getAllReservas(){
        List<ReservationResponse> response = new ArrayList<>();
        Iterable<Reserva> reservas = reservaRepository.findAll();
        for (Reserva reserva : reservas) {
            ReservationResponse reservation = new ReservationResponse();
            reservation.setIdReservation(reserva.getId());
            DateTimeFormatter patron = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formato ="T00:00:00.000+00:00";
            reservation.setStartDate(reserva.getFechaInicio().format(patron) + formato);
            reservation.setDevolutionDate(reserva.getFechaEntrega().format(patron) + formato);
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
            motorcycle.setId(moto.getId());
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

    public String saveReservation(ReservationRequest reservation) {
        LocalDate fechaInicio = reservation.getStartDate();
        LocalDate fechaDevolucion = reservation.getDevolutionDate();
        if (fechaInicio.isAfter(fechaDevolucion)){
            return "Error, la fecha inicial debe ser anterior a la de devolucion";
        }
        Reserva reserva = new Reserva();

        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaEntrega(fechaDevolucion);
        Optional<Cliente> cliente = clienteRepository.findById(reservation.getClient().getIdClient());
        if (cliente.isPresent()) {
            reserva.setIdCliente(cliente.get());
        }
        Optional<Motocicleta> moto = motoRepository.findById(reservation.getMotorbike().getId());
        if (moto.isPresent()) {
            reserva.setIdMotocicleta(moto.get());
        }
        Optional<EstadoReserva> estadoReserva = estadoReservaRepository.findById(1);
        if (estadoReserva.isPresent()){
            reserva.setIdEstadoReserva(estadoReserva.get());
        }

        reservaRepository.save(reserva);
        return "";
    }
}
