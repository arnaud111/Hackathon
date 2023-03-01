package com.greenring.hackathon.controller.user;

import com.greenring.hackathon.controller.trash.request.CreateTrashRequest;
import com.greenring.hackathon.controller.user.request.CreateUserRequest;
import com.greenring.hackathon.domain.model.Trash;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.TrashApi;
import com.greenring.hackathon.domain.port.client.UserApi;
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
@RequestMapping("/user")
public class UserController {
    private final UserApi api;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid CreateUserRequest createUserRequest) {
        //TODO Mapper et supprimé cette merde en dessous
        User newUser =  User.builder()
                .firstname(createUserRequest.getFirstname())
                .lastname(createUserRequest.getLastname())
                .login(createUserRequest.getLogin())
                .password(createUserRequest.getPassword())
                .build();
        return api
                .create(newTrash)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
