package com.greenring.hackathon.application.service.validator;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Distributor;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface DistributorValidator {
    static Validation<ApplicationError, Distributor> validate(Distributor distributor){
        return distributor.get_id() != null && distributor.getName() != null && distributor.getRoom() != null && distributor.getProducts() != null
                ? Valid(distributor)
                : Invalid(new ApplicationError("Wrong distributor creation", "Check distributor's informations", distributor, null)
        );
    }
}
