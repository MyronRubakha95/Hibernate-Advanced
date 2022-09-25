package com.example.CarInfo.service;

import com.example.CarInfo.repository.CarRepository;
import com.example.CarInfo.entity.Car;
import com.example.CarInfo.entity.CarCategory;
import com.example.CarInfo.entity.CarDescription;
import com.example.CarInfo.entity.CarParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostConstruct
    void init() {

        Car car = new Car("Mers", 500);
        Car car1 = new Car("BMW", 450);
        Car car2 = new Car("Audi", 600);

        CarCategory carCategory = new CarCategory("a6");
        CarCategory carCategory1 = new CarCategory("x6");
        CarCategory carCategory2 = new CarCategory("AMG");

        CarParameters carParameters = new CarParameters(5000.0);
        CarParameters carParameters1 = new CarParameters(53000.0);
        CarParameters carParameters2 = new CarParameters(50400.0);

        CarDescription carDescription = new CarDescription("Red");
        CarDescription carDescription1 = new CarDescription("Black");
        CarDescription carDescription2 = new CarDescription("White");

        car.setCarParameters(carParameters);
        car.setCarDescription(carDescription1);
        car.getCarCategories(carCategory2);

        car1.setCarParameters(carParameters1);
        car1.setCarDescription(carDescription);
        car1.setCarCategories(carCategory1);

        car2.setCarDescription(carDescription2);
        car2.setCarCategory(Arrays.asList(carCategory, carCategory1));
        car2.setCarParameters(carParameters2);

        carRepository.saveAll(Arrays.asList(car, car1, car2));
    }

    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    public Car saveCar(Car car) {
        carRepository.save(car);
        return car;
    }
}