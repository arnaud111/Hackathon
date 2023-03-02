package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Transaction;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;
import java.util.UUID;

public interface TransactionApi {
    Either<ApplicationError, Transaction> create(Transaction transaction);
    List<Transaction> getAll();
    Option<Transaction> getOne(UUID transaction_id);
}
