package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.mapper.TrashEntityMapper;
import com.greenring.hackathon.database.repository.TrashRepository;
import com.greenring.hackathon.domain.model.Trash;
import com.greenring.hackathon.domain.port.server.TrashPersistenceSpi;
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
public class TrashDatabaseAdapter implements TrashPersistenceSpi {

    private final TrashRepository repository;
    @Override
    @Transactional
    public Either<ApplicationError, Trash> save(Trash o) {
        val entity = TrashEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save trash",throwable.getMessage(),o,throwable))
                .map(TrashEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public Option<Trash> findById(UUID uuid) {
        return repository.findBy_id(uuid).map(TrashEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public List<Trash> findAll() {
        return repository.findAll().stream().map(TrashEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Option<Trash> deleteBy_id(UUID id) {
        return repository.deleteBy_id(id).map(TrashEntityMapper::toDomain);
    }
}
