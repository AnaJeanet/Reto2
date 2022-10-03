package com.reto.reto3.repository;

import com.reto.reto3.entities.Categoria;
import com.reto.reto3.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajesRepository extends CrudRepository<Mensaje, Integer> {
}
