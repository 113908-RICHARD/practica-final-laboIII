package com.example.demo.Models;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarType {
   private Long id;
    private String types;
    private BigDecimal price;
}
