package com.vayadrop.vayadrop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedResponseDto {
    private Long idUser;
    private String username;
    private String email;
    private Set<String> role;
    private String token;
}
