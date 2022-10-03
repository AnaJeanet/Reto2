package com.reto.reto3.repository;

import com.reto.reto3.entities.Categoria;
import com.reto.reto3.entities.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
}
