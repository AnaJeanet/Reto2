package com.reto.reto3.controllers;

import com.reto.reto3.dto.Client;
import com.reto.reto3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(path = "/api/Client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/all")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody Client client){
        clientService.saveClient(client);
    }
    
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable int idClient){
        return clientService.getClient(idClient);
    }
    
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return clientService.delete(id);
    }
}
