package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String description;
    private Boolean isDisabled;
    private LocalDate created;

    @OneToMany(mappedBy = "rol")
    private List<User> users;

    public Rol() {
    }

    public Rol(Integer idRol, String description, Boolean isDisabled, LocalDate created) {
        this.idRol = idRol;
        this.description = description;
        this.isDisabled = isDisabled;
        this.created = created;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
