package com.reto.reto3.services;

import com.reto.reto3.dto.*;
import com.reto.reto3.entities.*;
import com.reto.reto3.repository.CategoriaRepository;
import com.reto.reto3.repository.EstadoMotocicletaRepository;
import com.reto.reto3.repository.MotosCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    private MotosCrudRepository motosRepository;
    private CategoriaRepository categoriaRepository;
    private EstadoMotocicletaRepository estadoMotocicletaRepository;

    @Autowired
    public MotoService(MotosCrudRepository motosRepository, CategoriaRepository categoriaRepository, EstadoMotocicletaRepository estadoMotocicletaRepository) {
        this.motosRepository = motosRepository;
        this.categoriaRepository = categoriaRepository;
        this.estadoMotocicletaRepository = estadoMotocicletaRepository;
    }

    public List<Motorcycle> getAllMotos(){
        List<Motorcycle> resultado = new ArrayList<>();
        Iterable<Motocicleta> motos = motosRepository.findAll();
        for (Motocicleta moto : motos) {
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.setId(moto.getId());
            motorcycle.setBrand(moto.getMarca());
            motorcycle.setDescription(moto.getDescripcion());
            motorcycle.setYear(moto.getAnio());
            motorcycle.setName(moto.getNombre());
            //Categoria
            Categoria categoria = moto.getIdCategoria();
            Category category = new Category();
            category.setId(categoria.getId());
            category.setDescription(categoria.getDescripcion());
            category.setName(categoria.getNombre());
            motorcycle.setCategory(category);
            resultado.add(motorcycle);
            //Mensajes
            List<Message> messageList = new ArrayList<>();
            for (Mensaje mensaje : moto.getMensajes()) {
                Message message = new Message();
                message.setIdMessage(mensaje.getId());
                message.setMessageText(mensaje.getTexto());
                messageList.add(message);
            }
            motorcycle.setMessages(messageList);

            //Reservations
            List<ReservationRequest> reservationList = new ArrayList<>();
            for (Reserva reserva : moto.getReservas()) {
                ReservationRequest reservation = new ReservationRequest();
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
                reservationList.add(reservation);
            }
            motorcycle.setReservations(reservationList);
            
        }
        return resultado;
    }

    public void saveMoto(Motorcycle moto) {
        Motocicleta motocicleta = new Motocicleta();
        motocicleta.setMarca(moto.getBrand());
        motocicleta.setAnio(moto.getYear());
        Optional<Categoria> categoria = categoriaRepository.findById(moto.getCategory().getId());
        if (categoria.isPresent()){
            motocicleta.setIdCategoria(categoria.get());
        }
        motocicleta.setNombre(moto.getName());
        motocicleta.setDescripcion(moto.getDescription());
        Iterable<EstadoMotocicleta> estados = estadoMotocicletaRepository.findAll();
        EstadoMotocicleta estado = estados.iterator().next();

        if (estado != null) {
            motocicleta.setIdEstadoMotocicletas(estado);
        }

        motosRepository.save(motocicleta);
    }
}
