package io.mazur.carshop.service.impl;

import io.mazur.carshop.controller.dto.CarDTO;
import io.mazur.carshop.domain.model.Car;
import io.mazur.carshop.domain.repository.CarRepository;
import io.mazur.carshop.exception.CarNotFoundException;
import io.mazur.carshop.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {

    private final CarRepository repository;

    @Override
    public void saveNewCar(CarDTO carDTO) {
        repository.save(Car.builder()
                .carModel(carDTO.getCarModel())
                .carMark(carDTO.getCarMark())
                .carType(carDTO.getCarType())
                .price(carDTO.getPrice())
                .year(carDTO.getYear())
                .countryOfRegistration(carDTO.getCountryOfRegistration())
                .description(carDTO.getDescription())
                .build());
    }

    @Override
    public Stream<Car> getAllCarsStream() {
        return repository.getAll();
    }

    @Override
    public Car getCarById(Long carId) {
        return repository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found"));
    }

    @Override
    public List<Car> getSortedCarsByYear() {
        return repository.getAllCarsSortedByYear();
    }

    @Override
    public List<Car> getSortedCarsByPrice() {
        return repository.getAllCarsSortedByPrice();
    }

    @Override
    public void delete(Long carId) {
        if (getCarById(carId) == null) {
            throw new CarNotFoundException("Car not found");
        } else {
            repository.deleteCarById(carId);
        }
    }
}
