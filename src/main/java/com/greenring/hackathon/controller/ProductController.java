package com.greenring.hackathon.controller;

import com.greenring.hackathon.application.dto.ProductCreationDto;
import com.greenring.hackathon.application.mapper.ProductDtoMapper;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.port.client.ProductApi;
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

    @GetMapping(value = "/{product_id}")
    public Option<Product> getProduct(@PathVariable UUID product_id) {
        return productApi
                .getOne(product_id);
    }

    @GetMapping(value = "/")
    public List<Product> getProducts() {
        return productApi
                .getAll();
    }

}
