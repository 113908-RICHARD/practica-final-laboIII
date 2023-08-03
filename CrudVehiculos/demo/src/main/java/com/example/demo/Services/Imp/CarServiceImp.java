package com.example.demo.Services.Imp;

import com.example.demo.Dtos.Cars.CarDTO;
import com.example.demo.Dtos.Cars.CarDTOupdate;
import com.example.demo.Enities.CarEntity;
import com.example.demo.Enities.CarTypeEntity;
import com.example.demo.Models.Car;
import com.example.demo.Models.CarType;
import com.example.demo.Repositories.CarJPArepository;
import com.example.demo.Repositories.CarTypeJPArepository;
import com.example.demo.Services.CarService;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.weaver.IClassFileProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarJPArepository carJPArepository;

    @Autowired
    private CarTypeJPArepository carTypeJPArepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Car> getAllCars() {
        List<CarEntity> carsE = carJPArepository.findAll();
        List<Car> cars = new ArrayList<>();
        if (carsE.isEmpty()){
            throw  new EntityNotFoundException();
        }
        for (CarEntity car:carsE
             ) {
            Car carToAdd = modelMapper.map(car,Car.class);
            cars.add(carToAdd);

        }
        return cars;
    }

    @Override
    public Car getCarById(Long id) {
        CarEntity carEntity = carJPArepository.getReferenceById( id);
        if(Objects.isNull(carEntity)){
            throw  new EntityNotFoundException();
        }
        Car car = modelMapper.map(carEntity,Car.class);
        return car;
    }

    @Override
    public Car saveCar(CarDTO car) {
        CarEntity carToSave = new CarEntity();
        CarTypeEntity carType = carTypeJPArepository.getReferenceById(car.getCartype());
        carToSave.setCartype(carType);
        carToSave.setBrand(car.getBrand());
        carToSave.setModel(car.getModel());
        carJPArepository.save(carToSave);
        return  modelMapper.map(carToSave,Car.class);
    }

    @Override
    public Car updateCar(CarDTOupdate car) {
        Optional<CarEntity> carEntityOptional = carJPArepository.findById(car.getId());
        if (carEntityOptional.isPresent()){
            CarEntity carToUpdate = carEntityOptional.get();
            carToUpdate.setModel(car.getModel());
            CarTypeEntity carType = carTypeJPArepository.getReferenceById(car.getCartype());
            carToUpdate.setCartype(carType);
            carToUpdate.setBrand(car.getBrand());
            carJPArepository.save(carToUpdate);
            return modelMapper.map(carToUpdate,Car.class);

        }else {
            throw new EntityNotFoundException();
        }


    }

    @Override
    public Car deleteCar(Long id) {
        CarEntity car = carJPArepository.getReferenceById(id);
        if (car == null){
            throw  new EntityNotFoundException();
        }
        carJPArepository.delete(car);
        return modelMapper.map(car,Car.class);
    }
}
