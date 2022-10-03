package com.reto.reto3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private Integer id;
    private String name;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Motorcycle> motorbikes;

    public Category() {
    }

    public Category(Integer id, String name, String description, ArrayList<Motorcycle> motorbikes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.motorbikes = motorbikes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getMotorbikes() {
        return motorbikes;
    }

    public void setMotorbikes(List<Motorcycle> motorbikes) {
        this.motorbikes = motorbikes;
    }
}
