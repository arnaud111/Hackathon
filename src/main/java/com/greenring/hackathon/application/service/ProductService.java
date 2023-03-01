package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.ProductValidator;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.ProductApi;
import com.greenring.hackathon.domain.port.server.ProductPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService implements ProductApi {

    private final ProductPersistenceSpi spi;

    @Override
    public Either<ApplicationError, Product> create(Product product) {
        return ProductValidator.validate(product)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }
}
