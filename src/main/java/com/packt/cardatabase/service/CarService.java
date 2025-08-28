package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.repository.CarRepository;
import com.packt.cardatabase.dto.CarDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<CarDto> findAll() {
        List<CarDto> carDtos = new ArrayList<>();
        for(Car car : carRepository.findAll()) {
            CarDto carDto = CarDto.builder()
                    .id(car.getId())
                    .brand(car.getBrand())
                    .model(car.getModel())
                    .color(car.getColor())
                    .registrationNumber(car.getRegistrationNumber())
                    .modelYear(car.getModelYear())
                    .price(car.getPrice())
                    .build();
            carDtos.add(carDto);
        }
        return carDtos;
    }

    public CarDto addCar(CarDto carDto) {
        Car car = Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .color(carDto.getColor())
                .modelYear(carDto.getModelYear())
                .registrationNumber(carDto.getRegistrationNumber())
                .price(carDto.getPrice())
                .build();
        carRepository.save(car);
        return carDto;
    }

    @Transactional
    public CarDto updateCar(CarDto carDto) {
        Car car = carRepository.findById(carDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        car.updateCar(carDto);
        return carDto;
    }

    public Long deleteCar(Long carId) {
        carRepository.deleteById(carId);
        return carId;
    }

}
