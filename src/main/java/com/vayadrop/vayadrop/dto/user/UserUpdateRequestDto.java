package com.vayadrop.vayadrop.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {
    private String username;
    private String email;
    private String password;
    private String address;
    private Boolean isPublicAddress;
    private String comment;
}
