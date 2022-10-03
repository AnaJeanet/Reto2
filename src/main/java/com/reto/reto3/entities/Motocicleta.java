package com.reto.reto3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "motocicletas")
public class Motocicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motocicleta", nullable = false)
    private Integer id;

    @Column(name = "marca", nullable = false, length = 45)
    private String marca;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria idCategoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado_motocicletas", nullable = false)
    private EstadoMotocicleta idEstadoMotocicletas;

    @OneToMany(mappedBy = "idMotocicleta")
    private List<Mensaje> mensajes = new ArrayList<>();

    @OneToMany(mappedBy = "idMotocicleta")
    private List<Reserva> reservas = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public EstadoMotocicleta getIdEstadoMotocicletas() {
        return idEstadoMotocicletas;
    }

    public void setIdEstadoMotocicletas(EstadoMotocicleta idEstadoMotocicletas) {
        this.idEstadoMotocicletas = idEstadoMotocicletas;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}