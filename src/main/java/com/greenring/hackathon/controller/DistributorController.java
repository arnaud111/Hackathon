package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.DistributorCreationDto;
import com.greenring.hackathon.application.mapper.DistributorDtoMapper;
import com.greenring.hackathon.application.mapper.UserDtoMapper;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping(value = "/{distributor_id}")
    public Option<Distributor> getDistributor(@PathVariable UUID distributor_id) {
        return distributorApi
                .getOne(distributor_id);
    }

    @GetMapping(value = "/")
    public List<Distributor> getDistributors() {
        return distributorApi
                .getAll();
    }

    @GetMapping(value = "/{distributor_id}/addProduct/{product_id}")
    public ResponseEntity<Object> addProduct(@PathVariable UUID distributor_id, @PathVariable UUID product_id) {
        return distributorApi
                .addProduct(distributor_id,product_id)
                .map(DistributorDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping(value = "/{distributor_id}/buyProduct/{product_id}/{user_id}")
    public ResponseEntity<Object> buyProduct(@PathVariable UUID distributor_id, @PathVariable UUID product_id, @PathVariable UUID user_id) {
        return distributorApi
                .buyProduct(distributor_id,product_id,user_id)
                .map(UserDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }
}
