package com.reto.reto3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ReservationResponse {
    private Integer idReservation;

    private String startDate;

    private String devolutionDate;
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Motorcycle motorbike;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Client client;
    private String score;

    public ReservationResponse() {
    }

    public ReservationResponse(Integer idReservation, String startDate, String devolutionDate, String status, Motorcycle motorbike, Client client, String score) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
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
