package io.mazur.carshop.controller;

import io.mazur.carshop.controller.dto.CarDTO;
import io.mazur.carshop.controller.dto.CarResponse;
import io.mazur.carshop.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public CarResponse submitNewCar(@RequestBody @NotNull @Valid
                                         CarDTO carDTO) {
        carService.saveNewCar(carDTO);
        return CarResponse.builder()
                .message("Car was saved")
                .info(Collections.singletonMap("RandomValue", 66))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @Transactional(readOnly = true)
    public CarResponse getAllCars() {
        return CarResponse.builder()
                .message("All cars are displayed")
                .info(Collections
                        .singletonMap("cars", carService
                                .getAllCarsStream()
                                .collect(Collectors.toList())))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CarResponse getCarById(@PathVariable("id") Long id){
        return CarResponse.builder()
                .message("Car with selected id")
                .info(Collections
                        .singletonMap("car", carService
                                .getCarById(id)))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/sorted/by_year")
    public CarResponse getCarsSortedByYear() {
        return CarResponse.builder()
                .message("Cars sorted by year are displayed")
                .info(Collections
                        .singletonMap("cars", carService
                                .getSortedCarsByYear()))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/sorted/by_price")
    public CarResponse getCarsSortedByPrice() {
        return CarResponse.builder()
                .message("Cars sorted by price are displayed")
                .info(Collections
                        .singletonMap("cars", carService
                                .getSortedCarsByPrice()))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/delete/{id}")
    public CarResponse deleteCarById(@PathVariable("id") Long id) {
        carService.delete(id);
        return CarResponse.builder()
                .message("Car with selected id was deleted")
                .info(Collections
                        .singletonMap("RandomValue", 66))
                .build();
    }

}
