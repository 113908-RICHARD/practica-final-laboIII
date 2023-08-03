package com.example.demo.Controllers;

import com.example.demo.Dtos.Cars.CarDTO;
import com.example.demo.Dtos.Rents.GetRentByDate.RentByDateRequest;
import com.example.demo.Dtos.Rents.GetRentByDate.RentByDateResponse;
import com.example.demo.Dtos.Rents.rentDTO;
import com.example.demo.Models.Car;
import com.example.demo.Models.Rent;
import com.example.demo.Services.RentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("")
    public ResponseEntity<List<Rent>> getByAll(){


        return  ResponseEntity.ok(rentService.getAllRents());
    }
    @PostMapping
    public ResponseEntity<Rent> saveRent(@RequestBody @Valid rentDTO rentDTO){
        return ResponseEntity.ok(rentService.saveRent(rentDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Rent> getById(@PathVariable Long id){


        return  ResponseEntity.ok(rentService.getRentById(id));
    }

    @PostMapping("/by-date")
    public ResponseEntity<RentByDateResponse> getByDate(@RequestBody @Valid RentByDateRequest rentByDateRequest){
        return ResponseEntity.ok(rentService.getByDate(rentByDateRequest));
    }
}
