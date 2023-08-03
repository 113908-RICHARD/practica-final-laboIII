package com.example.demo.Controllers;

import com.example.demo.Dtos.Cars.CarDTO;
import com.example.demo.Dtos.Cars.CarDTOupdate;
import com.example.demo.Models.Car;
import com.example.demo.Services.CarService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("")
    public ResponseEntity<List<Car>> getByAll(){


        return  ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id){


        return  ResponseEntity.ok(carService.getCarById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> Delete(@PathVariable Long id){
        return  ResponseEntity.ok(carService.deleteCar(id));
    }
    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody @Valid CarDTO carDTO){
        return ResponseEntity.ok(carService.saveCar(carDTO));
    }
    @PutMapping
    public ResponseEntity<Car> UpdateCar(@RequestBody @Valid CarDTOupdate carDTO){
        return ResponseEntity.ok(carService.updateCar(carDTO));
    }
}
