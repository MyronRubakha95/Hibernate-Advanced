package com.example.CarInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCar() {
        return carService.findAll();
    }

    @PostMapping
    public Car creatCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

}