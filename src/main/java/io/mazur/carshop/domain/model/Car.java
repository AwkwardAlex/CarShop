package io.mazur.carshop.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Cars")
@Getter
@Setter
public class Car {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @Column(name = "CAR_MARK")
    private String carMark;

    @Column(name = "CAR_TYPE")
    private String carType;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "YEAR")
    private short year;

    @Column(name = "COUNTRY_OF_REGISTRATION")
    private String countryOfRegistration;

    @Column(name = "DESCRIPTION")
    private String description;
}
