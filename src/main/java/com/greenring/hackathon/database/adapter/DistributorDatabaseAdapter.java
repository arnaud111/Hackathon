package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.mapper.DistributorEntityMapper;
import com.greenring.hackathon.database.mapper.DistributorEntityMapper;
import com.greenring.hackathon.database.repository.DistributorRepository;
import com.greenring.hackathon.database.repository.DistributorRepository;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.port.server.DistributorPersistenceSpi;
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
public class DistributorDatabaseAdapter implements DistributorPersistenceSpi {
    private final DistributorRepository repository;
    @Override
    @Transactional
    public Either<ApplicationError, Distributor> save(Distributor o) {
        val entity = DistributorEntityMapper.fromDomain(o);
        return Try(() -> repository.save(entity))
                .toEither()
                .mapLeft(throwable -> new ApplicationError("Unable to save trash",throwable.getMessage(),o,throwable))
                .map(DistributorEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public Option<Distributor> findById(UUID uuid) {
        return repository.findBy_id(uuid).map(DistributorEntityMapper::toDomain);
    }

    @Override
    @Transactional
    public List<Distributor> findAll() {
        return repository.findAll().stream().map(DistributorEntityMapper::toDomain).collect(Collectors.toList());
    }
}
