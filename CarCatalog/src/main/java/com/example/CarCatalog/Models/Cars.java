package com.example.CarCatalog.Models;

import jakarta.persistence.*;

@Entity

public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String brand;
    private String modelcar;
    private String description;

    public Cars() {
    }
    public Cars( String brand, String modelcar, String description) {
        this.brand = brand;
        this.modelcar = modelcar;
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelcar() {
        return modelcar;
    }

    public void setModelcar(String modelcar) {
        this.modelcar = modelcar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



