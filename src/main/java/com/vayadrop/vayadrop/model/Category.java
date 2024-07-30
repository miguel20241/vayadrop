package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategory;

    private String description;
    private Boolean disabled;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "category")
    private List<OffersCategory> offersCategories;

    public Category() {
    }

    public Category(Long idCategory, String description, Boolean disabled, LocalDateTime createdAt, List<OffersCategory> offersCategories) {
        this.idCategory = idCategory;
        this.description = description;
        this.disabled = disabled;
        this.createdAt = createdAt;
        this.offersCategories = offersCategories;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<OffersCategory> getOffersCategories() {
        return offersCategories;
    }

    public void setOffersCategories(List<OffersCategory> offersCategories) {
        this.offersCategories = offersCategories;
    }
}
