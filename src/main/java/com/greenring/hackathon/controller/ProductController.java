package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.ProductCreationDto;
import com.greenring.hackathon.application.mapper.ProductDtoMapper;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.port.client.ProductApi;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductApi productApi;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid ProductCreationDto dto) {

        return productApi
                .create(ProductDtoMapper.productCreationToDomain(dto))
                .map(ProductDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

}
