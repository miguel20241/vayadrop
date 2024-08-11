package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offer")
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

}
