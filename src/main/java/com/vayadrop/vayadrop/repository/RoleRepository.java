package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
