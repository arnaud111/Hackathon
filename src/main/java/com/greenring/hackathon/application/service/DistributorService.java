package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.DistributorValidator;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DistributorService {
/*
    public Either<ApplicationError, Distributor> create(Distributor distributor) {
        return DistributorValidator.validate(distributor)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }*/
}
