package com.greenring.hackathon.domain.port.server;

import com.greenring.hackathon.application.ApplicationError;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.List;

public interface PersistenceSpi<T, ID>  {

    Either<ApplicationError, T> save(T o);

    Option<T> findById(ID id);

    List<T> findAll();


}
