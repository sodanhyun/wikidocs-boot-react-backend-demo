package com.packt.cardatabase.domain.repository;

import com.packt.cardatabase.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}