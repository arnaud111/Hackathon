package com.greenring.hackathon.application.mapper;

import com.greenring.hackathon.application.dto.UserCreationDto;
import com.greenring.hackathon.application.dto.UserDto;
import com.greenring.hackathon.domain.model.User;
import org.apache.commons.codec.digest.DigestUtils;


public interface UserDtoMapper {
    static UserDto toDto(User user) {
        return new UserDto(
                user.get_id(),
                user.getLogin(),
                user.getPassword(),
                user.getCoins(),
                user.getFirstname(),
                user.getLastname(),
                user.getAdmin()
        );
    }

    static User userCreationToDomain(UserCreationDto dto){

        return User.builder()
                .login(dto.login())
                .firstname(dto.firstname())
                .lastname(dto.lastname())
                .password(DigestUtils.sha256Hex(dto.password()))
                .build();
    }
}
