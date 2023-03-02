package com.greenring.hackathon.database.mapper;

import com.greenring.hackathon.database.entity.DistributorEntity;
import com.greenring.hackathon.domain.model.Distributor;
import io.vavr.collection.List;

import java.util.stream.Collectors;

public interface DistributorEntityMapper {
    static Distributor toDomain(DistributorEntity entity){
        return Distributor.builder()
                .name(entity.getName())
                .room(entity.getRoom())
                ._id(entity.get_id())
                .products(List.ofAll(entity.getProducts()).map(ProductEntityMapper::toDomain).collect(Collectors.toList()))
                .build();
    }

    static DistributorEntity fromDomain(Distributor domain){
        return DistributorEntity.builder()
                ._id(domain.get_id())
                .name(domain.getName())
                .room(domain.getRoom())
                .products(domain.getProducts().stream().map(ProductEntityMapper::fromDomain).collect(Collectors.toList())).build();
    }
}
