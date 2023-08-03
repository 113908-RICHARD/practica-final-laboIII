package com.example.demo.Services;

import com.example.demo.Dtos.Cars.CarDTO;
import com.example.demo.Dtos.Cars.CarDTOupdate;
import com.example.demo.Dtos.Rents.GetRentByDate.RentByDateRequest;
import com.example.demo.Dtos.Rents.GetRentByDate.RentByDateResponse;
import com.example.demo.Dtos.Rents.RentDTOupdate;
import com.example.demo.Dtos.Rents.rentDTO;
import com.example.demo.Models.Car;
import com.example.demo.Models.Rent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentService {
    List<Rent> getAllRents();
    Rent getRentById(Long id);

    Rent saveRent(rentDTO rent);

    Rent updateRent(RentDTOupdate rent);

    Rent deleteRent(Long id);

    RentByDateResponse getByDate(RentByDateRequest rent);
}
