package com.greenring.hackathon.database.mapper;

import com.greenring.hackathon.database.entity.TransactionEntity;
import com.greenring.hackathon.domain.model.Transaction;

public interface TransactionEntityMapper {

    static Transaction toDomain(TransactionEntity entity) {
        return Transaction.builder()
                ._id(entity.get_id())
                .date(entity.getDate())
                .product_id(entity.getProduct_id())
                .user_id(entity.getUser_id())
                .build();
    }

    static TransactionEntity fromDomain(Transaction domain) {
        return TransactionEntity.builder()
                ._id(domain.get_id())
                .date(domain.getDate())
                .product_id(domain.getProduct_id())
                .user_id(domain.getUser_id())
                .build();
    }
}
