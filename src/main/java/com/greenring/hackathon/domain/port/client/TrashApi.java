package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Trash;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;
import java.util.UUID;

public interface TrashApi {

    Either<ApplicationError, Trash> create(Trash trash);

    List<Trash> getAll();
    Option<Trash> getOne(UUID trash_id);

    Option<Trash>deleteTrash(UUID trash_id);

}
