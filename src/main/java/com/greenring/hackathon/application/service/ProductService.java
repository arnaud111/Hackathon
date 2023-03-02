package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.ProductValidator;
import com.greenring.hackathon.application.service.validator.ProductValidator;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.port.client.ProductApi;
import com.greenring.hackathon.domain.port.server.ProductPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductService implements ProductApi {

    private final ProductPersistenceSpi spi;

    @Override
    @Transactional
    public Either<ApplicationError, Product> create(Product product) {
        return ProductValidator.validate(product)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }

    @Override
    public List<Product> getAll() {
        return spi.findAll();
    }

    @Override
    public Option<Product> getOne(UUID product_id) {
        return spi.findById(product_id);
    }
}
