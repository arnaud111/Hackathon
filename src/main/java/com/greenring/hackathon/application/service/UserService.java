package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.UserApi;
import com.greenring.hackathon.domain.port.server.UserPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserService implements UserApi {

    private final UserPersistenceSpi userSpi;

    @Override
    @Transactional
    public Either<ApplicationError, User> create(User user) {
        return UserValidator.validate(user)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(userSpi::save);
    }

    @Override
    public List<User> getAll() {
        return userSpi.findAll();
    }

    @Override
    public Option<User> getOne(UUID user_id) {
        return userSpi.findById(user_id);
    }

    @Override
    public Either<ApplicationError, User> addCoins(UUID user_id) {
        Option<User> user = userSpi.findById(user_id);
        User newUser = user.get().updateCoins(user.get().getCoins()+1);
        return UserValidator.validate(newUser)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(userSpi::save);
    }

}
