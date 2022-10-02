/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.repository.crudRepository;

import com.reto3.entities.Client;
import com.reto3.entities.Motorbike;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Morales
 */
public interface MotorbikeCrudRepository extends CrudRepository<Motorbike,Integer> {

    public void delete(Client c);
    
}
