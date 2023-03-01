package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Product;
import io.vavr.control.Either;

public interface ProductApi {
    Either<ApplicationError, Product> create(Product product);
}
