package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByIdUserAndIsDisabledFalse(Long idUser);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<Object> findByUsername(String username);

    Optional<Object> findByEmail(String email);

    Optional<User> findByIdUserAndEmailAndIsDisabledFalse(Long idUser, String email);
}
