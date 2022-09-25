package com.example.CarInfo.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CarCategory")
public class CarCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String carName;

    @ManyToMany
    @JoinTable(name = "сarName",
            joinColumns = @JoinColumn(name = "car_id"))

    private List<Car> cars = new ArrayList<>();

    public CarCategory() {

    }

    public CarCategory(String carName) {
        this.carName = carName;
    }

    public void car(Car car) {
        cars.add(car);
    }
}