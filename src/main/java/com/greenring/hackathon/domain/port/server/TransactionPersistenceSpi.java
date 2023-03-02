package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.domain.model.Transaction;
import com.greenring.hackathon.domain.model.Trash;
import io.vavr.control.Option;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionPersistenceSpi extends PersistenceSpi<Transaction, UUID>{
    List<Transaction> findAllTransactionsby_idAnddate(UUID id,LocalDateTime startDate, LocalDateTime endDate);

    List<Transaction> findAllTransactionsbyDate(UUID id,LocalDateTime startDate, LocalDateTime endDate);

}
