package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.mapper.UserEntityMapper;
import com.greenring.hackathon.database.repository.UserRepository;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.server.UserPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.vavr.API.Try;

@Service
@RequiredArgsConstructor
public class UserDatabaseAdapter implements UserPersistenceSpi {

    private final UserRepository repository;
    @Override
    @Transactional
    public Either<ApplicationError, User> save(User o) {
        val entity = UserEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save user",throwable.getMessage(),o,throwable))
                .map(UserEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public Option<User> findById(UUID uuid) {
        return repository.findBy_id(uuid).map(UserEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return repository.findAll().stream().map(UserEntityMapper::toDomain).collect(Collectors.toList());
    }
}
