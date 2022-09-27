/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.reto3.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Motocicletas")

/**
 *
 * @author Jeanet
 */
public class Moto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMotocicletas;
    private String marca;
    private String nombre;
    private Integer anion;
    private String descripcion;
    private Integer idCategoria;

    public Moto(Integer idMotocicletas, String marca, String nombre, Integer anion, String descripcion, Integer idCategoria) {
        this.idMotocicletas = idMotocicletas;
        this.marca = marca;
        this.nombre = nombre;
        this.anion = anion;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
    }

    public Moto() {
    }

    public Integer getIdMotocicletas() {
        return idMotocicletas;
    }

    public void setIdMotocicletas(Integer idMotocicletas) {
        this.idMotocicletas = idMotocicletas;
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

    public Integer getAnion() {
        return anion;
    }

    public void setAnion(Integer anion) {
        this.anion = anion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    
}