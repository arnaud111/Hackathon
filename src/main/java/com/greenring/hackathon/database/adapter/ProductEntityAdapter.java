package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.repository.ProductRepository;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.port.server.ProductPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductEntityAdapter implements ProductPersistenceSpi {

    private final ProductRepository repository;
    @Override
    public Either<ApplicationError, Product> save(Product o) {
        return null;
    }

    @Override
    public Option<Product> findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
