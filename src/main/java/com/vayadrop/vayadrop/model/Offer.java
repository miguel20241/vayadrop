package com.vayadrop.vayadrop.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOffer;

    private String refNumber;
    private String description;
    private String mainPicture;
    private Boolean active;
    private Boolean disabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "offer")
    private List<Message> messages;

    @OneToMany(mappedBy = "offer")
    private List<Picture> pictures;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @OneToMany(mappedBy = "offer")
    private List<OffersCategory> offersCategories;

    /*@ManyToMany
    @JoinTable(name = "offersCategory",
            joinColumns = @JoinColumn(name = "idOffer"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> categories;*/

    public Offer() {
    }

    public Offer(Long idOffer, String refNumber, String description, String mainPicture, Boolean active, Boolean disabled, LocalDateTime createdAt, LocalDateTime updatedAt, List<Message> messages, List<Picture> pictures, User user, List<OffersCategory> offersCategories) {
        this.idOffer = idOffer;
        this.refNumber = refNumber;
        this.description = description;
        this.mainPicture = mainPicture;
        this.active = active;
        this.disabled = disabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.messages = messages;
        this.pictures = pictures;
        this.user = user;
        this.offersCategories = offersCategories;
    }

    public Long getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Long idOffer) {
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
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OffersCategory> getOffersCategories() {
        return offersCategories;
    }

    public void setOffersCategories(List<OffersCategory> offersCategories) {
        this.offersCategories = offersCategories;
    }
}
