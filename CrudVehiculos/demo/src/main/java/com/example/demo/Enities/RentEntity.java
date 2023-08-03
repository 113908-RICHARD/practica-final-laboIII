package com.example.demo.Enities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data

@Table(name = "Rents")
@AllArgsConstructor
@NoArgsConstructor
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String customer;


    @ManyToOne
    @JoinColumn(name = "carId")
    private CarEntity car;

    @Column
    private Integer rentedDays;

    @Column
    private LocalDateTime start_rent;

    @Column
    private LocalDateTime end_rent;

    @Column
    private Integer totalPrice;
}
