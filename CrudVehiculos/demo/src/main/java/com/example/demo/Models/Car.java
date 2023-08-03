package com.example.demo.Models;

import lombok.*;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Car {
   private Long Id;
  private CarType cartype;
   private String brand;
  private String model;
}
