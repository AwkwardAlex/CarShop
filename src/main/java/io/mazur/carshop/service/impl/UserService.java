package io.mazur.carshop.service.impl;

import io.mazur.carshop.controller.dto.UserDTO;
import io.mazur.carshop.domain.model.User;
import io.mazur.carshop.domain.repository.UserRepository;
import io.mazur.carshop.exception.UserNotFoundException;
import io.mazur.carshop.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private UserRepository repository;

    Calendar now = Calendar.getInstance();


    @Override
    public User signUp(UserDTO userDTO) {
        return repository.save(User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .yearOfAccountCreation((short) now.get(Calendar.YEAR))
                .mobilePhone(userDTO.getPhoneNumber())
                .build());
    }

    @Override
    public User getUserById(Long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
