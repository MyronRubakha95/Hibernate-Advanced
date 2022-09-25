package com.example.CarInfo.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    private List<CarCategory> carCategory = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carParameters_id")
    private CarParameters carParameters;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private CarDescription carDescription;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CarCategory> getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(List<CarCategory> carCategory) {
        this.carCategory = carCategory;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", carCategory=" + carCategory +
                ", carParameters=" + carParameters +
                ", carDescription=" + carDescription +
                '}';
    }

    public CarParameters getCarParameters() {
        return carParameters;
    }

    public void setCarParameters(CarParameters carParameters) {
        this.carParameters = carParameters;
    }

    public CarDescription getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(CarDescription carDescription) {
        this.carDescription = carDescription;
    }


    public void getCarCategories(CarCategory carCategory2) {
    }

    public void setCarCategories(CarCategory carCategory1) {
    }
}