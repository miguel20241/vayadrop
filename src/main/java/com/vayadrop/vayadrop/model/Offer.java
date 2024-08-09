package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOffer;
    private String refNumber;
    private String description;
    private String mainPicture;
    private Boolean isActive;
    private Boolean isDisabled;
    private LocalDate created;
    private LocalDate lastUpdated;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @OneToMany(mappedBy = "offer")
    private List<Message> messages;

    @OneToMany(mappedBy = "offer")
    private List<Picture> pictures;

    @OneToMany(mappedBy = "offer")
    private List<OffersCategory> offersCategories;

    @OneToMany(mappedBy = "offer")
    private List<Favorite> favorites;

    public Offer() {
    }

    public Offer(Integer idOffer, String refNumber, String description, String mainPicture, Boolean isActive, Boolean isDisabled, LocalDate created, LocalDate lastUpdated, User user) {
        this.idOffer = idOffer;
        this.refNumber = refNumber;
        this.description = description;
        this.mainPicture = mainPicture;
        this.isActive = isActive;
        this.isDisabled = isDisabled;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.user = user;
    }

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
