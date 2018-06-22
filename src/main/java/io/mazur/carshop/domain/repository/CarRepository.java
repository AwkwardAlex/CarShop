package io.mazur.carshop.domain.repository;

import io.mazur.carshop.domain.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "select * from cars", nativeQuery = true)
    Stream<Car> getAll();

    Car getCarById(Long id);

    @Query(value = "select * from cars order by year", nativeQuery = true)
    List<Car> getAllCarsSortedByYear();

    @Query(value = "select * from cars order by price", nativeQuery = true)
    List<Car> getAllCarsSortedByPrice();

    void deleteCarById(Long id);
}
