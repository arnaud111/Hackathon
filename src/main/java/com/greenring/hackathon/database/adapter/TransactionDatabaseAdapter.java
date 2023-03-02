package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.mapper.TransactionEntityMapper;
import com.greenring.hackathon.database.repository.TransactionRepository;
import com.greenring.hackathon.domain.model.Transaction;
import com.greenring.hackathon.domain.port.server.TransactionPersistenceSpi;
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
public class TransactionDatabaseAdapter implements TransactionPersistenceSpi {

    private final TransactionRepository repository;

    @Override
    @Transactional
    public Either<ApplicationError, Transaction> save(Transaction o) {
        val entity = TransactionEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save transaction",throwable.getMessage(),o,throwable))
                .map(TransactionEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public Option<Transaction> findById(UUID uuid) {
        return repository.findBy_id(uuid).map(TransactionEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public List<Transaction> findAll() {
        return repository.findAll().stream().map(TransactionEntityMapper::toDomain).collect(Collectors.toList());
    }
}
