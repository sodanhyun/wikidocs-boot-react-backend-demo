package com.carbackend;

import com.carbackend.domain.AppUser;
import com.carbackend.domain.Car;
import com.carbackend.domain.repository.AppUserRepository;
import com.carbackend.domain.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class CarbackendApplication implements CommandLineRunner {

    private final CarRepository carRepository;
    private final AppUserRepository appUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarbackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 애플리케이션 로딩(스프링 컨틱스트 등) 후 실행하고싶은 코드
        carRepository.save(Car.builder()
                .brand("Ford")
                .model("Mustang")
                .color("Red")
                .registrationNumber("ADF-1121")
                .modelYear(2023)
                .price(59000)
                .build());
        carRepository.save(Car.builder()
                .brand("Nissan")
                .model("Leaf")
                .color("White")
                .registrationNumber("SSJ-3002")
                .modelYear(2020)
                .price(29000)
                .build());
        carRepository.save(Car.builder()
                .brand("Toyota")
                .model("Prius")
                .color("Silver")
                .registrationNumber("KKO-0212")
                .modelYear(2022)
                .price(39000)
                .build());
        for(Car car : carRepository.findAll()) {
            log.info("brand: {}, model: {}", car.getBrand(), car.getModel());
        }

        // username: user, password: user
        appUserRepository.save(AppUser.builder()
                .username("user")
                .password("user")
                .role("USER")
                .build());
        // username: admin, password: admin
        appUserRepository.save(AppUser.builder()
                .username("admin")
                .password("admin")
                .role("ADMIN")
                .build());
    }
}
