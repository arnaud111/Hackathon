package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.domain.model.Transaction;

import java.util.UUID;

public interface TransactionPersistenceSpi extends PersistenceSpi<Transaction, UUID>{

}
