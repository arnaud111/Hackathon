package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.port.server.ProductPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductDatabaseAdapter implements ProductPersistenceSpi {
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
