package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.database.repository.DistributorRepository;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.port.server.DistributorPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
public class DistributorEntityAdapter implements DistributorPersistenceSpi {

    private final DistributorRepository repository;
    @Override
    public Either<ApplicationError, Distributor> save(Distributor o) {
        return null;
    }

    @Override
    public Option<Distributor> findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Distributor> findAll() {
        return null;
    }
}
