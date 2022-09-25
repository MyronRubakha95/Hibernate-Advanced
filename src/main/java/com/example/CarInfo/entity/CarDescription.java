package com.example.CarInfo.entity;


import javax.persistence.*;

@Entity
@Table(name = "CarDescription")
public class CarDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String colorCar;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    public CarDescription(String colorCar) {
        this.colorCar = colorCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarDescription{" +
                "id=" + id +
                ", colorCar='" + colorCar + '\'' +
                ", car=" + car +
                '}';
    }
}