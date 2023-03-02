package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.TransactionValidator;
import com.greenring.hackathon.domain.model.Transaction;
import com.greenring.hackathon.domain.port.client.ProductApi;
import com.greenring.hackathon.domain.port.client.TransactionApi;
import com.greenring.hackathon.domain.port.server.TransactionPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TransactionService implements TransactionApi {

    private final TransactionPersistenceSpi spi;

    @Override
    @Transactional
    public Either<ApplicationError, Transaction> create(Transaction transaction) {
        return TransactionValidator.validate(transaction)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }

    @Override
    public List<Transaction> getAll() {
        return spi.findAll();
    }

    @Override
    public Option<Transaction> getOne(UUID product_id) {
        return spi.findById(product_id);
    }

    @Override
    public List<Transaction> getToday(UUID user_id, LocalDateTime startDate, LocalDateTime endDate) {
        return spi.findAllTransactionsby_idAnddate(user_id,startDate,endDate);
    }

    @Override
    public List<Transaction> getHistoric(UUID user_id, LocalDateTime startDate, LocalDateTime endDate) {
        return spi.findAllTransactionsbyDate(user_id,startDate,endDate);
    }

}
