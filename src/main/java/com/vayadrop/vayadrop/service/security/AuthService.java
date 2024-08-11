package com.vayadrop.vayadrop.service.security;

import com.vayadrop.vayadrop.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
