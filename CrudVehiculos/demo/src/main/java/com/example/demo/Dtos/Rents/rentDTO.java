package com.example.demo.Dtos.Rents;

import com.example.demo.Models.Car;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class rentDTO {

    private String customer;
    private Long car;
    private Integer rentedDays;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startRent;


    private BigDecimal totalPrice;
}
