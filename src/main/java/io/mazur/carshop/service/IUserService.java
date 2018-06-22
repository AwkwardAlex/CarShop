package io.mazur.carshop.service;

import io.mazur.carshop.controller.dto.UserDTO;
import io.mazur.carshop.domain.model.User;

public interface IUserService {

    User signUp(UserDTO userDTO);

    User getUserById(Long userId);
}
