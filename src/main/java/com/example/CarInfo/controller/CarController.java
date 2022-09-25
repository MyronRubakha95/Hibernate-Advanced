package com.example.CarInfo.controller;

import com.example.CarInfo.service.CarService;
import com.example.CarInfo.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCar() {
        return carService.findAll();
    }

    @PostMapping("/car")
    public Car saveCar(@RequestBody Car car) {
        carService.saveCar(car);
        return car;
    }
}