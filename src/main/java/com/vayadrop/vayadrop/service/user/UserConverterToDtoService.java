package com.vayadrop.vayadrop.service.user;

import com.vayadrop.vayadrop.dto.user.BaseUserDto;
import com.vayadrop.vayadrop.model.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserConverterToDtoService {
    public <T extends BaseUserDto> T convertToDto(User user, Function<User, T> mapper) {
        return mapper.apply(user);
    }
}
