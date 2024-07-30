package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPicture;

    private String href;
    private Boolean disabled;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "idOffer", nullable = false)
    private Offer offer;

    public Picture() {
    }

    public Picture(Long idPicture, String href, Boolean disabled, LocalDate createdAt, Offer offer) {
        this.idPicture = idPicture;
        this.href = href;
        this.disabled = disabled;
        this.createdAt = createdAt;
        this.offer = offer;
    }

    public Long getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(Long idPicture) {
        this.idPicture = idPicture;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
