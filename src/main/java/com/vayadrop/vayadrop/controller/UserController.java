package com.vayadrop.vayadrop.controller;

import com.vayadrop.vayadrop.dto.UserCreatedResponseDto;
import com.vayadrop.vayadrop.model.User;
import com.vayadrop.vayadrop.service.UserService;
import com.vayadrop.vayadrop.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vayadrop/api/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;


    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    private ResponseEntity<UserCreatedResponseDto> createUser(@Valid @RequestBody User newUser, UriComponentsBuilder ucb) {
        User createdUser = userService.createUser(newUser);

        UserCreatedResponseDto userCreatedResponseDto = userService.convertToDto(newUser);

        URI locationOfNewUser = ucb
                .path("vayadrop/user/{id}")
                .buildAndExpand(createdUser.getIdUser())
                .toUri();

        return ResponseEntity.created(locationOfNewUser).body(userCreatedResponseDto);
    }
}
