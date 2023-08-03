package com.example.demo.Enities;



import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@Table(name = "Cartypes")
@AllArgsConstructor
@NoArgsConstructor
public class CarTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String types;

    @Column
    private Integer price;





}
