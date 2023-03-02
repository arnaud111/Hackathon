package com.greenring.hackathon.database.adapter;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Trash;
import com.greenring.hackathon.domain.port.server.TrashPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrashDatabaseAdapter implements TrashPersistenceSpi {
    @Override
    public Either<ApplicationError, Trash> save(Trash o) {
        return null;
    }

    @Override
    public Option<Trash> findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Trash> findAll() {
        return null;
    }
}
