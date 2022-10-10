package com.reto.reto3.services;

import com.reto.reto3.dto.Client;
import com.reto.reto3.dto.Message;
import com.reto.reto3.dto.Motorcycle;
import com.reto.reto3.dto.ReservationRequest;
import com.reto.reto3.entities.Cliente;
import com.reto.reto3.entities.Mensaje;
import com.reto.reto3.entities.Motocicleta;
import com.reto.reto3.entities.Reserva;
import com.reto.reto3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        Iterable<Cliente> clientes = clienteRepository.findAll();
        for (Cliente cliente : clientes) {
            Client client = new Client();
            client.setIdClient(cliente.getId());
            client.setEmail(cliente.getCorreo());
            client.setPassword(cliente.getContraseña());
            client.setName(cliente.getNombre());
            client.setAge(cliente.getEdad());
            List<Mensaje> mensajes = cliente.getMensajes();
            List<Message>messageList = new ArrayList<>();
            for (Mensaje mensaje : mensajes) {
                Message message = new Message();
                message.setIdMessage(mensaje.getId());
                message.setMessageText(mensaje.getTexto());
                messageList.add(message);
            }
            client.setMessages(messageList);
            List<ReservationRequest> reservationList = new ArrayList<>();
            List<Reserva> reservas = cliente.getReservas();
            for (Reserva reserva: reservas) {
                ReservationRequest reservation = new ReservationRequest();
                reservation.setIdReservation(reserva.getId());
                reservation.setStartDate(reserva.getFechaInicio());
                reservation.setDevolutionDate(reserva.getFechaEntrega());
                if (reserva.getIdEstadoReserva() != null) {
                    reservation.setStatus(reserva.getIdEstadoReserva().getDescripcion());
                }
                Motocicleta moto = reserva.getIdMotocicleta();
                Motorcycle motorcycle = new Motorcycle();
                motorcycle.setId(motorcycle.getId());
                motorcycle.setBrand(moto.getMarca());
                motorcycle.setDescription(moto.getDescripcion());
                motorcycle.setYear(moto.getAnio());
                motorcycle.setName(moto.getNombre());
                reservation.setMotorbike(motorcycle);
                reservation.setScore(reserva.getScore());
                reservationList.add(reservation);
            }
            client.setReservations(reservationList);

            clients.add(client);
        }
        return clients;
    }

    public void saveClient(Client client) {
        Cliente cliente = new Cliente();
        cliente.setNombre(client.getName());
        cliente.setContraseña(client.getPassword());
        cliente.setCorreo(client.getEmail());
        cliente.setEdad(client.getAge());
        clienteRepository.save(cliente);
    }

    public String deleteById(Integer id) {
        Optional<Cliente> clientDB = clienteRepository.findById(id);
        if (clientDB.isPresent()){
            clienteRepository.deleteById(id);
            return "";
        }
        return "Client not found";
    }

    public String updateClient(Client client) {
        Optional<Cliente> clientDB = clienteRepository.findById(client.getIdClient());
        if (clientDB.isPresent()){
            Cliente cliente = new Cliente();
            cliente.setId(client.getIdClient());
            cliente.setNombre(client.getName());
            cliente.setContraseña(client.getPassword());
            cliente.setCorreo(client.getEmail());
            cliente.setEdad(client.getAge());
            clienteRepository.save(cliente);
            return "";
        }
        return "Client not found";
    }
}
