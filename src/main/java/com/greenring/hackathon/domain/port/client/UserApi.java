package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Either;

public interface UserApi {

    Either<ApplicationError, User> create(User user);

}
