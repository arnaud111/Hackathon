package com.greenring.hackathon.application.service.validator;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface WalletValidator {

    static Validation<ApplicationError, User> validate(User user){
        return user.getCoins() >= 0
                ? Valid(user)
                : Invalid(new ApplicationError("No money", "GO JETER DES DECHETS", user, null)
        );
    }
}
