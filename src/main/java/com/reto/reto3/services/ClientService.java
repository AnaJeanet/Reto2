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
    
    
    public Client update(Client p){
        if(p.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(p.getIdClient());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getAge()!=null){
                    q.get().setAge(p.getAge());
                }
                if(p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int idClient){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(idClient);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }

    public Optional<Client> getClient(int clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
