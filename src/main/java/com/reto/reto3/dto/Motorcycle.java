package com.reto.reto3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Motorcycle {
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Category category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Message> messages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ReservationRequest> reservations;

    public Motorcycle() {
    }

    public Motorcycle(Integer id, String name, String brand, Integer year, String description, Category category,
                      List<Message> messages, List<ReservationRequest> reservations) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<ReservationRequest> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationRequest> reservations) {
        this.reservations = reservations;
    }
}
