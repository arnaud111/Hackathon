package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.DistributorApi;
import com.greenring.hackathon.domain.port.client.UserApi;
import com.greenring.hackathon.domain.port.server.UserPersistenceSpi;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class UserService implements UserApi {

    private final UserPersistenceSpi spi;

    @Override
    @Transactional
    public Either<ApplicationError, User> create(User user) {
        return UserValidator.validate(user)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }

}
