package com.greenring.hackathon.application.service.validator;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Trash;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface TrashValidator {
    static Validation<ApplicationError, Trash> validate(Trash trash){
        return trash.get_id() != null && trash.getColor() != null && trash.getRoom() != null && trash.getSite() != null
                ? Valid(trash)
                : Invalid(new ApplicationError("Wrong trash creation", "Check trash's informations", trash, null)
        );
    }
}
