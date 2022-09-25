package com.example.CarInfo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CarParameters")
public class CarParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double enginePower;
    @OneToMany(mappedBy = "carParameters",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();

    public CarParameters() {

    }

    public CarParameters(double enginePower) {
        this.enginePower = enginePower;

    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarParameters{" +
                "id=" + id +
                ", enginePower=" + enginePower +
                ", cars=" + cars +
                '}';
    }
}