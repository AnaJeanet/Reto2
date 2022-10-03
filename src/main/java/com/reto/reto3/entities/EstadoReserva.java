package com.reto.reto3.entities;

import javax.persistence.*;

@Entity
@Table(name = "estado_reserva")
public class EstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_reserva", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}