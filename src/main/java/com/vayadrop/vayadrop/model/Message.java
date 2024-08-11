package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @ManyToOne
    @JoinColumn(name = "idOffer", nullable = false)
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "idUserFrom", nullable = false)
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "idUserTo", nullable = false)
    private User userTo;

    @ManyToOne
    @JoinColumn(name = "idParent")
    private Message parentMessage;

    private String messageText;
    private Boolean isDisabled;
    private Boolean isRead;
    private LocalDate created;
    private LocalDate lastUpdated;
}
