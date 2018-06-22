package io.mazur.carshop.domain.repository;

import io.mazur.carshop.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean emailAlreadyUsed(String email);

    boolean usernameAlreadyExists(String username);
}
