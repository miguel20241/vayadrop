package com.vayadrop.vayadrop.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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

    public Message() {
    }

    public Message(Integer idMessage, Offer offer, User userFrom, User userTo, Message parentMessage, String messageText, Boolean isDisabled, Boolean isRead, LocalDate created, LocalDate lastUpdated) {
        this.idMessage = idMessage;
        this.offer = offer;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.parentMessage = parentMessage;
        this.messageText = messageText;
        this.isDisabled = isDisabled;
        this.isRead = isRead;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
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

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
