package com.vayadrop.vayadrop.dto.user;

import com.vayadrop.vayadrop.model.Offer;
import com.vayadrop.vayadrop.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserGetPublicProfileResponseDto implements BaseUserDto{
    private Long idUser;
    private String username;
    private String email;
    private String comment;

    private List<Offer> offers;

    public UserGetPublicProfileResponseDto(User user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.comment = user.getComment();
        this.offers = user.getOffers();
    }
}
