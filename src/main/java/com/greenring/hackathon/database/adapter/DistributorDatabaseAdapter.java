package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.port.server.DistributorPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DistributorDatabaseAdapter implements DistributorPersistenceSpi {
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
