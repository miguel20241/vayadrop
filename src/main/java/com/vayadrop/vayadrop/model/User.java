package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.util.List;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private Boolean showAddress;
    private Boolean disabled;
    private LocalDate createdAt;
    private LocalDate lastUpdatedAt;

    @ManyToOne()
    @JoinColumn(name="idRol", nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "userFrom")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "userTo")
    private List<Message> receivedMessages;

    @OneToMany(mappedBy = "user")
    private List<Offer> offers;

    public User() {
    }

    public User(Long idUser, String name, String surName, String email, String password, String address, Boolean showAddress, Rol rol, Boolean disabled, LocalDate createdAt, LocalDate lastUpdatedAt) {        this.idUser = idUser;
        this.name = name;
        this.surname = surName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.showAddress = showAddress;
        this.rol = rol;
        this.disabled = disabled;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getShowAddress() {
        return showAddress;
    }

    public void setShowAddress(Boolean showAddress) {
        this.showAddress = showAddress;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDate lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
