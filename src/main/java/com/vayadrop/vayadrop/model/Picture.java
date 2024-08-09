package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPicture;

    private String href;
    private Boolean isDisabled;
    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "idOffer", nullable = false)
    private Offer offer;

    public Picture() {
    }

    public Picture(Integer idPicture, String href, Boolean isDisabled, LocalDate created, Offer offer) {
        this.idPicture = idPicture;
        this.href = href;
        this.isDisabled = isDisabled;
        this.created = created;
        this.offer = offer;
    }

    public Integer getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(Integer idPicture) {
        this.idPicture = idPicture;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
