package com.vayadrop.vayadrop.dto.user;

import com.vayadrop.vayadrop.model.Role;
import com.vayadrop.vayadrop.model.User;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// Mapeador de dtos para User. Crear un método para cada dto necesario
public class UserDtoMappers {
    public static Function<User, UserCreatedResponseDto> toUserCreatedResponseDto(String token) {
        return user -> {
            Set<String> roles = user.getRole().stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet());

            return new UserCreatedResponseDto(user.getIdUser(), user.getUsername(), user.getEmail(), roles, token);
        };
    }

    public static Function<User, UserGetResponseDto> toUserGetResponseDto() {
        return user -> new UserGetResponseDto(user);
    }
}
