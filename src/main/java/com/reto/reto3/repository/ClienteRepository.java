package com.reto.reto3.repository;

import com.reto.reto3.entities.Categoria;
import com.reto.reto3.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
