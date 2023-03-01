package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Trash;
import io.vavr.control.Either;

public interface TrashApi {

    Either<ApplicationError, Trash> create(Trash trash);
}
