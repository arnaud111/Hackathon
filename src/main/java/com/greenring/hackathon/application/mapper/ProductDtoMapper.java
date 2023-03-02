package com.greenring.hackathon.application.mapper;

import com.greenring.hackathon.application.dto.ProductCreationDto;
import com.greenring.hackathon.application.dto.ProductDto;
import com.greenring.hackathon.domain.model.Product;

public interface ProductDtoMapper {
    static ProductDto toDto(Product product) {
        return new ProductDto(
                product.get_id(),
                product.getName(),
                product.getPrice()
        );
    }

    static Product productCreationToDomain(ProductCreationDto dto){
        return Product.builder()
                .name(dto.name())
                .price(dto.price())
                .build();
    }
}
