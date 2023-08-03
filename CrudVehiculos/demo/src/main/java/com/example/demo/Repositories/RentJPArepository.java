package com.example.demo.Repositories;

import com.example.demo.Enities.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentJPArepository extends JpaRepository<RentEntity,Long> {


    Optional<List<RentEntity>> findByCarId(Long aLong);
}
