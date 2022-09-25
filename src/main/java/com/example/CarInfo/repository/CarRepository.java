package com.example.CarInfo.repository;

import com.example.CarInfo.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

}