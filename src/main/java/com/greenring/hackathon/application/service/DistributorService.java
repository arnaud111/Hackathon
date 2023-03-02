package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.DistributorValidator;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import com.greenring.hackathon.domain.port.server.DistributorPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class DistributorService implements DistributorApi {

    private final DistributorPersistenceSpi spi;

    @Override
    @Transactional
    public Either<ApplicationError, Distributor> create(Distributor distributor) {
        return DistributorValidator.validate(distributor)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }
}
