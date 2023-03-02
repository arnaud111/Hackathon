package com.greenring.hackathon.controller.trash;

import com.greenring.hackathon.controller.trash.request.CreateTrashRequest;
import com.greenring.hackathon.domain.model.Trash;
import com.greenring.hackathon.domain.port.client.TrashApi;
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
@RequestMapping("/trashs")
public class TrashController {

    private final TrashApi api;
/*
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid CreateTrashRequest createTrashRequest) {
        Trash newTrash =  Trash.builder().color(createTrashRequest.getColor())
                .room(createTrashRequest.getRoom())
                .site(createTrashRequest.getSite())
                .build();
        return api
                .create(newTrash)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }*/
}
