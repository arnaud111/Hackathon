package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
/*
    public Either<ApplicationError, User> create(User user) {
        return UserValidator.validate(hero)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }
*/
}
