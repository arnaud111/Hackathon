package com.greenring.hackathon.application.service.validator;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Transaction;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface TransactionValidator {

    static Validation<ApplicationError, Transaction> validate(Transaction transaction){
        return transaction.get_id() != null && transaction.getDate() != null && transaction.getUser_id() != null
                ? Valid(transaction)
                : Invalid(new ApplicationError("Wrong transaction creation", "Check transaction's informations", transaction, null)
        );
    }
}
