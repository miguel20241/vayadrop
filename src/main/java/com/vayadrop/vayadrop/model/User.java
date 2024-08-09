package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.util.List;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    private String userName;
    private String surname;
    private String email;
    private String password;
    private String address;
    private Boolean isPublicAddress;
    private String comment;
    private Boolean isDisabled;
    private LocalDate created;
    private LocalDate lastUpdate;

    @ManyToOne
    @JoinColumn(name = "rol", nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "userFrom")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "userTo")
    private List<Message> receivedMessages;

    @OneToMany(mappedBy = "user")
    private List<Offer> offers;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    public User() {
    }

    public User(Long idUser, String userName, String surname, String email, String password, String address, Boolean isPublicAddress, String comment, Boolean isDisabled, LocalDate created, LocalDate lastUpdate, Rol rol) {
        this.idUser = idUser;
        this.userName = userName;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.isPublicAddress = isPublicAddress;
        this.comment = comment;
        this.isDisabled = isDisabled;
        this.created = created;
        this.lastUpdate = lastUpdate;
        this.rol = rol;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Boolean getPublicAddress() {
        return isPublicAddress;
    }

    public void setPublicAddress(Boolean publicAddress) {
        isPublicAddress = publicAddress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
