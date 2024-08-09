package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    private String description;
    private Boolean isDisabled;
    private LocalDate created;

    @OneToMany(mappedBy = "category")
    private List<OffersCategory> offersCategories;

    public Category() {
    }

    public Category(Integer idCategory, String description, Boolean isDisabled, LocalDate created, List<OffersCategory> offersCategories) {
        this.idCategory = idCategory;
        this.description = description;
        this.isDisabled = isDisabled;
        this.created = created;
        this.offersCategories = offersCategories;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
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
