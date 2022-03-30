package com.example.inventory.rest.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Motorcycle {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    int VIN;
    String make;
    String model;
    String type;
    int year;
    double price;

    public Motorcycle() {}

    public Motorcycle (Long id, int VIN, String make, String model, String type, int year, double price) {
        this.id = id;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.price = price;
    }


    //Getters and Setter

    public Long getId() {
        return id;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
