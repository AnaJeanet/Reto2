package com.reto.reto3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Message {
    private Integer idMessage;
    private String messageText;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Motorcycle motorbike;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Client client;

    public Message() {
    }

    public Message(Integer idMessage, String messageText, Motorcycle motorbike, Client client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.motorbike = motorbike;
        this.client = client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
}
