package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.UserCreationDto;
import com.greenring.hackathon.application.mapper.UserDtoMapper;
import com.greenring.hackathon.domain.port.client.UserApi;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api
@RequestMapping("/users")
public class UserController {
    private final UserApi userApi;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid UserCreationDto dto) {

        return userApi
                .create(UserDtoMapper.userCreationToDomain(dto))
                .map(UserDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
