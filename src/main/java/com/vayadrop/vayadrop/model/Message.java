package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMessage;

    private String messageText;
    private Boolean disabled;
    private LocalDate createdAt;
    private LocalDate lastUpdated;

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

    public Message() {
    }

    public Message(Long idMessage, String messageText, Boolean disabled, LocalDate createdAt, LocalDate lastUpdated, Offer offer, User userFrom, User userTo, Message parentMessage) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.disabled = disabled;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
        this.offer = offer;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.parentMessage = parentMessage;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public Message getParentMessage() {
        return parentMessage;
    }

    public void setParentMessage(Message parentMessage) {
        this.parentMessage = parentMessage;
    }
}
