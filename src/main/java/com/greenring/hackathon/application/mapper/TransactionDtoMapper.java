package com.greenring.hackathon.application.mapper;

import com.greenring.hackathon.application.dto.TransactionCreationDto;
import com.greenring.hackathon.application.dto.TransactionDto;
import com.greenring.hackathon.domain.model.Transaction;

public interface TransactionDtoMapper {

    static TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(
                transaction.get_id(),
                transaction.getDate(),
                transaction.getProduct_id(),
                transaction.getUser_id()
        );
    }

    static Transaction transactionCreationToDomain(TransactionCreationDto dto){
        return Transaction.builder()
                .user_id(dto.user_id())
                .date(dto.date())
                .product_id(dto.product_id())
                .build();
    }
}
