package com.vayadrop.vayadrop.service.user;

import com.vayadrop.vayadrop.dto.user.UserCreatedResponseDto;
import com.vayadrop.vayadrop.dto.user.UserDtoMappers;
import com.vayadrop.vayadrop.dto.user.UserGetResponseDto;
import com.vayadrop.vayadrop.model.Role;
import com.vayadrop.vayadrop.model.User;
import com.vayadrop.vayadrop.repository.RoleRepository;
import com.vayadrop.vayadrop.repository.UserRepository;
import com.vayadrop.vayadrop.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;
    private final UserConverterToDtoService userConverterToDtoService;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService, UserConverterToDtoService userConverterToDtoService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
        this.userConverterToDtoService = userConverterToDtoService;
    }

    public UserCreatedResponseDto createUser(User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken!");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already taken!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated(LocalDate.now());
        user.setLastUpdate(LocalDate.now());
        user.setPublicAddress(false);
        user.setDisabled(false);

        Optional<Role> userRole = Optional.ofNullable(roleRepository.findByName("ROLE_USER"));
        if (userRole.isPresent()) {
            user.setRole(Collections.singleton(userRole.get()));
        } else {
            throw new RuntimeException("User role not found");
        }

        User userCreated = userRepository.save(user);

        String token = authenticateNewUser(userCreated);

        return userConverterToDtoService.convertToDto(userCreated, UserDtoMappers.toUserCreatedResponseDto(token));
    }

    public String authenticateNewUser(User user) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return jwtTokenProvider.generateToken(authenticationToken);
    }

    public UserGetResponseDto getUserByIdAndEmail(Long idUser, Principal principal) {
        User user = userRepository.findByIdUserAndEmail(idUser, principal.getName()).orElse(null);

        if (user != null) {
            return userConverterToDtoService.convertToDto(user, UserDtoMappers.toUserGetResponseDto());
        }
        return null;
    }


}
