package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.TrashCreationDto;
import com.greenring.hackathon.application.mapper.TrashDtoMapper;
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

    private final TrashApi trashApi;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid TrashCreationDto dto) {

        return trashApi
                .create(TrashDtoMapper.trashCreationToDomain(dto))
                .map(TrashDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
