package com.greenring.hackathon.domain.port.client;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Distributor;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;
import java.util.UUID;

public interface DistributorApi {

    Either<ApplicationError, Distributor> create(Distributor distributor);

    List<Distributor> getAll();
    Option<Distributor> getOne(UUID distributor_id);

    Either<ApplicationError, User> buyProduct(UUID distributor_id, UUID product_id, UUID user_id);

    Either<ApplicationError, Distributor> addProduct(UUID distributor_id, UUID product_id);
}
