package com.greenring.hackathon.controller.product;

import com.greenring.hackathon.controller.distributor.request.CreateDistributorRequest;
import com.greenring.hackathon.controller.product.request.CreateProductRequest;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import com.greenring.hackathon.domain.port.client.ProductApi;
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

    private final ProductApi api;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid CreateProductRequest createProductRequest) {
        Product newProduct =  Product.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .build();
        return api
                .create(newProduct)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

}
