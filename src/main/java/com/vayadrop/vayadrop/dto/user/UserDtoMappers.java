package com.vayadrop.vayadrop.dto.user;

import com.vayadrop.vayadrop.model.Role;
import com.vayadrop.vayadrop.model.User;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// Mapeador de dtos para User. Crear un método para cada dto necesario
public class UserDtoMappers {
    public static Function<User, UserCreateResponseDto> toUserCreatedResponseDto(String token) {
        return user -> {
            Set<String> roles = user.getRole().stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet());

            return new UserCreateResponseDto(user.getIdUser(), user.getUsername(), user.getEmail(), user.getPublicAddress(), roles, token);
        };
    }

    public static Function<User, UserGetResponseDto> toUserGetResponseDto() {
        return user -> new UserGetResponseDto(user);
    }

    public static Function<User, UserUpdateResponseDto> toUserCreatedResponseDto() {
        return user -> new UserUpdateResponseDto(user);
    }
}
