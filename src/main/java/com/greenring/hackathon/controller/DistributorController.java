package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.DistributorCreationDto;
import com.greenring.hackathon.application.mapper.DistributorDtoMapper;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api
@RequestMapping("/distributors")
public class DistributorController {

    private final DistributorApi distributorApi;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody DistributorCreationDto dto) {
        return distributorApi
                .create(DistributorDtoMapper.distributorCreationToDomain(dto))
                .map(DistributorDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
