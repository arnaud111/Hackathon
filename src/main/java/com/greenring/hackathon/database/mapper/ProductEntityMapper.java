package com.greenring.hackathon.database.mapper;

import com.greenring.hackathon.database.entity.ProductEntity;
import com.greenring.hackathon.domain.model.Product;
import io.vavr.collection.List;

import java.util.stream.Collectors;

public interface ProductEntityMapper {

    static Product toDomain(ProductEntity entity) {
        return Product.builder()
                .price(entity.getPrice())
                .name(entity.getName())
                ._id(entity.get_id())
                .build();
    }

    static ProductEntity fromDomain(Product domain) {
        return ProductEntity.builder()
                ._id(domain.get_id())
                .price(domain.getPrice())
                .name(domain.getName())
                .build();
    }
}
