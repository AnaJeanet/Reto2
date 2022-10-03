package com.reto.reto3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Motorcycle {
    private Integer id;
    private String brand;
    private String name;
    private Integer year;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Category category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Message> messages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Reservation> reservations;

    public Motorcycle() {
    }

    public Motorcycle(Integer id, String brand, String name, Integer year, String description, Category category, List<Message> messages, List<Reservation> reservations) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
