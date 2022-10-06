package com.reto.reto3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class ReservationRequest {
    private Integer idReservation;

    private LocalDate startDate;

    private LocalDate devolutionDate;
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Motorcycle motorbike;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Client client;
    private String score;

    public ReservationRequest() {
    }

    public ReservationRequest(Integer idReservation, LocalDate startDate, LocalDate devolutionDate, String status, Motorcycle motorbike, Client client, String score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.motorbike = motorbike;
        this.client = client;
        this.score = score;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(LocalDate devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Motorcycle getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorcycle motorbike) {
        this.motorbike = motorbike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
