package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers_category")
public class OffersCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOffersCategory;

    @ManyToOne
    @JoinColumn(name = "idOffer", nullable = false)
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "idCategory", nullable = false)
    private Category category;
}
