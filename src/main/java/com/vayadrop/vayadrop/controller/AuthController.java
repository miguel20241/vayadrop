package com.vayadrop.vayadrop.controller;

import com.vayadrop.vayadrop.dto.JwtAuthResponse;
import com.vayadrop.vayadrop.dto.LoginDto;
import com.vayadrop.vayadrop.helper.JwtHelpers;
import com.vayadrop.vayadrop.service.security.AuthService;
import com.vayadrop.vayadrop.service.security.TokenBlackListService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TokenBlackListService tokenBlackListService;
    @Autowired
    private AuthService authService;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    // Build Logout REST API
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String token = JwtHelpers.getTokenFromRequest(request);

        if (token != null && !token.isEmpty()) {
            tokenBlackListService.blackListToken(token);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
