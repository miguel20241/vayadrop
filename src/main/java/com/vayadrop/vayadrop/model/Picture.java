package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pictures")
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

}
