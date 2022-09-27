package com.reto.reto3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "Reservas")
public class Reservas implements Serializable {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idReservas;
        private Integer idMotocicletas;
        private Integer cliente;
        private Integer idCliente;
        private Date fechaInicio;
        private Date fechaEntrega;
        private Integer estadoReserva;

    public Reservas(Integer idReservas, Integer idMotocicletas, Integer cliente, Integer idCliente, Date fechaInicio, Date fechaEntrega, Integer estadoReserva) {
        this.idReservas = idReservas;
        this.idMotocicletas = idMotocicletas;
        this.cliente = cliente;
        this.idCliente = idCliente;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estadoReserva = estadoReserva;
    }

    public Reservas() {
    }

    public Integer getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Integer idReservas) {
        this.idReservas = idReservas;
    }

    public Integer getIdMotocicletas() {
        return idMotocicletas;
    }

    public void setIdMotocicletas(Integer idMotocicletas) {
        this.idMotocicletas = idMotocicletas;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Integer estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
    
    

    
    
}
