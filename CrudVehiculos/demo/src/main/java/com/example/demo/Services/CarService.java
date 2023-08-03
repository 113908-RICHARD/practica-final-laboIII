package com.example.demo.Services;


import com.example.demo.Dtos.Cars.CarDTO;
import com.example.demo.Dtos.Cars.CarDTOupdate;
import com.example.demo.Enities.CarEntity;
import com.example.demo.Models.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getAllCars();
    Car getCarById(Long id);

    Car saveCar(CarDTO car);

    Car updateCar(CarDTOupdate car);

    Car deleteCar(Long id);
}
