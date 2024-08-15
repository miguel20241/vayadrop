package com.vayadrop.vayadrop.controller;

import com.vayadrop.vayadrop.dto.user.UserCreateResponseDto;
import com.vayadrop.vayadrop.dto.user.UserGetResponseDto;
import com.vayadrop.vayadrop.dto.user.UserUpdateRequestDto;
import com.vayadrop.vayadrop.dto.user.UserUpdateResponseDto;
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
    private ResponseEntity<UserCreateResponseDto> postUser(@Valid @RequestBody User newUser, UriComponentsBuilder uriBuilder) {
        UserCreateResponseDto userCreateResponseDto = userService.createUser(newUser);

        URI locationOfNewUser = uriBuilder
                .path("vayadrop/user/{id}")
                .buildAndExpand(userCreateResponseDto.getIdUser())
                .toUri();

        return ResponseEntity.created(locationOfNewUser).body(userCreateResponseDto);
    }

    @GetMapping("/{idUser}")
    private ResponseEntity<UserGetResponseDto> getUserOwnProfileById(@PathVariable Long idUser, Principal principal) {
        UserGetResponseDto userGetResponseDto = userService.getUserByIdAndEmail(idUser, principal);

        if (userGetResponseDto != null) {
            return ResponseEntity.ok().body(userGetResponseDto);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idUser}")
    private ResponseEntity<UserUpdateResponseDto> updateUserById(@PathVariable Long idUser, @RequestBody UserUpdateRequestDto userUpdate, Principal principal) {
        UserUpdateResponseDto userUpdateResponseDto = userService.updateUserById(idUser, userUpdate, principal);

        if (userUpdateResponseDto != null) {
            return ResponseEntity.ok().body(userUpdateResponseDto);
        }

        return ResponseEntity.notFound().build();
    }
}
