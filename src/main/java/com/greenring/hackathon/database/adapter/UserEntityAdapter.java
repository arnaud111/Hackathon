package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.repository.UserRepository;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.server.UserPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserEntityAdapter implements UserPersistenceSpi {

    private final UserRepository repository;
    @Override
    public Either<ApplicationError, User> save(User o) {
        return null;
    }

    @Override
    public Option<User> findById(UUID uuid) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
