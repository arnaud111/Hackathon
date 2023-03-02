package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;
import java.util.UUID;

public interface UserApi {

    Either<ApplicationError, User> create(User user);

    List<User> getAll();
    Option<User> getOne(UUID user_id);

    Either<ApplicationError, User> addCoins(UUID user_id);

}
