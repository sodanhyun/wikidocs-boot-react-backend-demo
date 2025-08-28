package com.packt.cardatabase.domain;

import com.packt.cardatabase.dto.CarDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand, model, color, registrationNumber;
	private Integer modelYear, price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public void updateCar(CarDto carDto) {
        this.brand = carDto.getBrand();
        this.model = carDto.getModel();
        this.color = carDto.getColor();
        this.registrationNumber = carDto.getRegistrationNumber();
        this.modelYear = carDto.getModelYear();
        this.price = carDto.getPrice();
    }
}
