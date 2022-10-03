package com.reto.reto3.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservas", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_motocicleta", nullable = false)
    private Motocicleta idMotocicleta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado_reserva", nullable = false)
    private EstadoReserva idEstadoReserva;

    @Column(name = "score", length = 100)
    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Motocicleta getIdMotocicleta() {
        return idMotocicleta;
    }

    public void setIdMotocicleta(Motocicleta idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EstadoReserva getIdEstadoReserva() {
        return idEstadoReserva;
    }

    public void setIdEstadoReserva(EstadoReserva idEstadoReserva) {
        this.idEstadoReserva = idEstadoReserva;
    }

}