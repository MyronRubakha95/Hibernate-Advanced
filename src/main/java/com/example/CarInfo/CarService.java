package com.example.CarInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostConstruct
    void init() {
        Car car = new Car("Audi", "Red", 9999.99);
        Car car1 = new Car("BMW", "Blue", 14330.77);
        Car car2 = new Car("Mercedes-Benz", "Black", 8000.00);
        carRepository.saveAll(Arrays.asList(car, car1, car2));
    }

    public List<Car> findAll() {
        return (List<Car>) carRepository.findAll();
    }

    public Car saveCar(Car car) {
        carRepository.save(car);
        return car;
    }
}