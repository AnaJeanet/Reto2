package com.reto.reto3.services;

import com.reto.reto3.dto.Category;
import com.reto.reto3.dto.Client;
import com.reto.reto3.dto.Message;
import com.reto.reto3.dto.Motorcycle;
import com.reto.reto3.entities.Categoria;
import com.reto.reto3.entities.Cliente;
import com.reto.reto3.entities.Mensaje;
import com.reto.reto3.entities.Motocicleta;
import com.reto.reto3.repository.ClienteRepository;
import com.reto.reto3.repository.MensajesRepository;
import com.reto.reto3.repository.MotosCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MensajesService {

    private final MensajesRepository mensajesRepository;
    private final ClienteRepository clienteRepository;
    private final MotosCrudRepository motosCrudRepository;

    @Autowired
    public MensajesService(MensajesRepository mensajesRepository, ClienteRepository clienteRepository,
                           MotosCrudRepository motosCrudRepository) {
        this.mensajesRepository = mensajesRepository;
        this.clienteRepository = clienteRepository;
        this.motosCrudRepository = motosCrudRepository;
    }


    public List<Message> getAllMessages() {
        Iterable<Mensaje> mensajes = mensajesRepository.findAll();
        List<Message> messageList = new ArrayList<>();
        for (Mensaje mensaje : mensajes) {
            Message message = new Message();
            message.setIdMessage(mensaje.getId());
            message.setMessageText(mensaje.getTexto());
            Motocicleta moto = mensaje.getIdMotocicleta();
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
            message.setMotorbike(motorcycle);
            //Cliente
            Cliente cliente = mensaje.getIdCliente();
            Client client = new Client();
            if (cliente != null) {
                client.setIdClient(cliente.getId());
                client.setEmail(cliente.getCorreo());
                client.setPassword(cliente.getContraseña());
                client.setName(cliente.getNombre());
                client.setAge(cliente.getEdad());
            }
            message.setClient(client);
            messageList.add(message);
        }
        return messageList;
    }

    public void saveMoto(Message message) {
        Mensaje mensaje = new Mensaje();
        mensaje.setTexto(message.getMessageText());
        Optional<Cliente> cliente = clienteRepository.findById(message.getClient().getIdClient());
        if (cliente.isPresent()) {
            mensaje.setIdCliente(cliente.get());
        }
        Optional<Motocicleta> moto = motosCrudRepository.findById(message.getMotorbike().getId());
        if (moto.isPresent()) {
            mensaje.setIdMotocicleta(moto.get());
        }
        mensajesRepository.save(mensaje);
    }
}
