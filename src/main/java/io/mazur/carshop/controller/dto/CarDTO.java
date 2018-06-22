package io.mazur.carshop.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CarDTO {

    @NotNull
    @Size(min = 1, max = 50, message = "From 0 to 50 chars.")
    private String carModel;

    @NotNull
    @Size(min = 1, max = 50, message = "From 0 to 50 chars.")
    private String carMark;

    @NotNull
    @Size(min = 1, max = 50, message = "From 0 to 50 chars.")
    private String carType;

    @NotNull(message = "price cannot be NULL.")
    private double price;

    @NotNull
    @Size(min = 1886, max = 2018, message = "From 1886 to 2018.")
    private short year;

    @NotNull
    @Size(min = 1, max = 50, message = "From 0 to 50 chars.")
    private String countryOfRegistration;

    @NotNull
    @Size(min = 1, max = 500, message = "From 0 to 500 chars.")
    private String description;
}
