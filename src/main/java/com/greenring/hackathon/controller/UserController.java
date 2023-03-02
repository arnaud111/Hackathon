package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.UserCreationDto;
import com.greenring.hackathon.application.mapper.UserDtoMapper;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.UserApi;
import io.swagger.annotations.Api;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Api
@RequestMapping("/users")
public class UserController {
    private final UserApi userApi;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody UserCreationDto dto) {

        return userApi
                .create(UserDtoMapper.userCreationToDomain(dto))
                .map(UserDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping(value = "/{user_id}")
    public Option<User> getUser(@PathVariable UUID user_id) {
        return userApi
                .getOne(user_id);
    }

    @GetMapping(value = "/")
    public List<User> getUsers() {
        return userApi
                .getAll();
    }

    @GetMapping(value = "/{user_id}/addCoin")
    public ResponseEntity<Object> addCoin(@PathVariable UUID user_id) {
        return userApi
                .addCoins(user_id)
                .map(UserDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
