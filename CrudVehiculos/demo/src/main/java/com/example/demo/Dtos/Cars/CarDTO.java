package com.example.demo.Dtos.Cars;

import com.example.demo.Models.CarType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarDTO {


    private Long cartype;
    private String brand;
    private String model;
}
