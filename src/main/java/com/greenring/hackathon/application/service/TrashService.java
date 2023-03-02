package com.greenring.hackathon.application.service;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.application.service.validator.TrashValidator;
import com.greenring.hackathon.application.service.validator.UserValidator;
import com.greenring.hackathon.domain.model.Trash;
import com.greenring.hackathon.domain.model.User;
import com.greenring.hackathon.domain.port.client.TrashApi;
import com.greenring.hackathon.domain.port.server.TrashPersistenceSpi;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TrashService implements TrashApi {

    private final TrashPersistenceSpi spi;

    @Override
    @Transactional
    public Either<ApplicationError, Trash> create(Trash trash) {
        return TrashValidator.validate(trash)
                .toEither()
                .peekLeft(System.out::println)
                .flatMap(spi::save);
    }

    @Override
    public List<Trash> getAll() {
        return spi.findAll();
    }

    @Override
    public Option<Trash> getOne(UUID product_id) {
        return spi.findById(product_id);
    }

    @Override
    public Option<Trash> deleteTrash(UUID trash_id) {
        return spi.deleteBy_id(trash_id);
    }


}
