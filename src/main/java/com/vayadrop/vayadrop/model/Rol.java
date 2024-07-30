package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRol;

    private String description;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "rol")
    private List<User> users;

    public Rol() {
    }

    public Rol(Long idRol, String description, LocalDateTime createdAt) {
        this.idRol = idRol;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
