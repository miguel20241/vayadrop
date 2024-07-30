package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
