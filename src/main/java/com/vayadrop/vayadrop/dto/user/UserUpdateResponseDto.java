package com.vayadrop.vayadrop.dto.user;

import com.vayadrop.vayadrop.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateResponseDto implements BaseUserDto{
    private Long idUser;
    private String username;
    private String email;
    private String address;
    private Boolean isPublicAddress;
    private String comment;

    public UserUpdateResponseDto(User user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.isPublicAddress = user.getPublicAddress();
        this.comment = user.getComment();
    }
}
