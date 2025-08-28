package com.packt.cardatabase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CarDto {
    private Long id;
    private String brand, model, color, registrationNumber;
    private Integer modelYear, price;
}
