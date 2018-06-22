package io.mazur.carshop.service;

import io.mazur.carshop.controller.dto.CarDTO;
import io.mazur.carshop.domain.model.Car;

import java.util.List;
import java.util.stream.Stream;

public interface ICarService {

    void saveNewCar(CarDTO carDTO);

    Stream<Car> getAllCarsStream();

    Car getCarById(Long carId);

    List<Car> getSortedCarsByYear();

    List<Car> getSortedCarsByPrice();

    void delete(Long id);
}
