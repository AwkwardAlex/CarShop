package io.mazur.carshop.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @NotNull(message = "email cannot be NULL")
    @Email(message = "invalid email")
    private String email;

    @NotNull(message = "password cannot be NULL")
    @Size(min = 4, max = 50, message = "password should have from 4 to 50 chars")
    private String password;

    @NotNull(message = "first name cannot be NULL")
    @Size(min = 1, max = 50, message = "first name should have from 1 to 50 chars")
    private String firstName;

    @NotNull(message = "last name cannot be NULL")
    @Size(min = 1, max = 50, message = "last name should have from 1 to 50 chars")
    private String lastName;

    @NotNull(message = "email cannot be NULL")
    @Size(min = 2018)
    private short yearOfCreation;

    @NotNull(message = "phone number cannot be NULL")
    @Size(min = 1, max = 50, message = "phone number should have from 1 to 20 chars")
    private String phoneNumber;
}
