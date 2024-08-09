package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFavorite;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idOffer", nullable = false)
    private Offer offer;

    private Boolean isDisabled;
    private LocalDate created;

    public Favorite() {
    }

    public Favorite(Integer idFavorite, User user, Offer offer, Boolean isDisabled, LocalDate created) {
        this.idFavorite = idFavorite;
        this.user = user;
        this.offer = offer;
        this.isDisabled = isDisabled;
        this.created = created;
    }

    public Integer getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(Integer idFavorite) {
        this.idFavorite = idFavorite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
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
