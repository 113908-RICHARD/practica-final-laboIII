package com.example.demo.Repositories;

import com.example.demo.Enities.CarTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeJPArepository extends JpaRepository<CarTypeEntity,Long> {
}
