package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Distributor;
import io.vavr.control.Either;

public interface DistributorApi {

    Either<ApplicationError, Distributor> create(Distributor distributor);
}
