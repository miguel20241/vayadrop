package com.vayadrop.vayadrop.dto.user;

import com.vayadrop.vayadrop.model.Favorite;
import com.vayadrop.vayadrop.model.Message;
import com.vayadrop.vayadrop.model.Offer;
import com.vayadrop.vayadrop.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserGetResponseDto implements BaseUserDto{
    private Long idUser;
    private String username;
    private String email;
    private String address;
    private Boolean isPublicAddress;
    private String comment;
    private LocalDate created;

    private List<Message> sentMessages;
    private List<Message> receivedMessages;
    private List<Offer> offers;
    private List<Favorite> favorites;

    public UserGetResponseDto(User user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.isPublicAddress = user.getPublicAddress();
        this.comment = user.getComment();
        this.created = user.getCreated();
        this.sentMessages = user.getSentMessages();
        this.receivedMessages = user.getReceivedMessages();
        this.offers = user.getOffers();
        this.favorites = user.getFavorites();
    }
}
