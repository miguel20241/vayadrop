package com.vayadrop.vayadrop.controller;

import com.vayadrop.vayadrop.dto.user.UserCreatedResponseDto;
import com.vayadrop.vayadrop.dto.user.UserGetResponseDto;
import com.vayadrop.vayadrop.model.User;
import com.vayadrop.vayadrop.service.user.UserService;
import com.vayadrop.vayadrop.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;

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
    private ResponseEntity<UserCreatedResponseDto> postUser(@Valid @RequestBody User newUser, UriComponentsBuilder ucb) {
        UserCreatedResponseDto userCreatedResponseDto = userService.createUser(newUser);

        URI locationOfNewUser = ucb
                .path("vayadrop/user/{id}")
                .buildAndExpand(userCreatedResponseDto.getIdUser())
                .toUri();

        return ResponseEntity.created(locationOfNewUser).body(userCreatedResponseDto);
    }

    @GetMapping("/{idUser}")
    private ResponseEntity<UserGetResponseDto> getUserOwnProfileById(@PathVariable Long idUser, Principal principal) {
        UserGetResponseDto userGetResponseDto = userService.getUserByIdAndEmail(idUser, principal);

        if (userGetResponseDto != null) {
            return ResponseEntity.ok().body(userGetResponseDto);
        }

        return ResponseEntity.notFound().build();
    }

}
