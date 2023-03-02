package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.mapper.ProductEntityMapper;
import com.greenring.hackathon.database.mapper.ProductEntityMapper;
import com.greenring.hackathon.database.repository.ProductRepository;
import com.greenring.hackathon.database.repository.ProductRepository;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.model.Product;
import com.greenring.hackathon.domain.port.server.ProductPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.vavr.API.Try;

@Service
@RequiredArgsConstructor
public class ProductDatabaseAdapter implements ProductPersistenceSpi {
    private final ProductRepository repository;
    @Override
    @Transactional
    public Either<ApplicationError, Product> save(Product o) {
        val entity = ProductEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save trash",throwable.getMessage(),o,throwable))
                .map(ProductEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public Option<Product> findById(UUID uuid) {
        return repository.findBy_id(uuid).map(ProductEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        return repository.findAll().stream().map(ProductEntityMapper::toDomain).collect(Collectors.toList());
    }
}
