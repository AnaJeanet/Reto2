package com.reto.reto3.entities;

import javax.persistence.*;

@Entity
@Table(name = "calificacion_reservas")
public class CalificacionReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion_reservas", nullable = false)
    private Integer id;

    @Column(name = "`califación`", nullable = false)
    private Integer califación;

    @Column(name = "mensaje", nullable = false, length = 250)
    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reservas", nullable = false)
    private Reserva idReservas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCalifación() {
        return califación;
    }

    public void setCalifación(Integer califación) {
        this.califación = califación;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Reserva getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(Reserva idReservas) {
        this.idReservas = idReservas;
    }

}