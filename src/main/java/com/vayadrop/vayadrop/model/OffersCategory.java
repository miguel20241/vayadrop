package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

@Entity
public class OffersCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOffersCategory;

    @ManyToOne
    @JoinColumn(name = "idOffer", nullable = false)
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "idCategory", nullable = false)
    private Category category;

    public OffersCategory() {
    }

    public OffersCategory(Integer idOffersCategory, Offer offer, Category category) {
        this.idOffersCategory = idOffersCategory;
        this.offer = offer;
        this.category = category;
    }

    public Integer getIdOffersCategory() {
        return idOffersCategory;
    }

    public void setIdOffersCategory(Integer idOffersCategory) {
        this.idOffersCategory = idOffersCategory;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
