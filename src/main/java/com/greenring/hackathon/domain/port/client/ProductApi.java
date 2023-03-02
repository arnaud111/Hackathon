package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.model.Product;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;
import java.util.UUID;

public interface ProductApi {
    Either<ApplicationError, Product> create(Product product);

    List<Product> getAll();
    Option<Product> getOne(UUID product_id);
}
