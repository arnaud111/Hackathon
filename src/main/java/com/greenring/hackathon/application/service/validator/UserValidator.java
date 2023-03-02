package com.greenring.hackathon.application.service.validator;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.User;
import io.vavr.control.Validation;
import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface UserValidator {
    static Validation<ApplicationError, User> validate(User user){
        return user.get_id() != null
                && user.getFirstname() != null
                && user.getLastname() != null
                && user.getLogin() != null
                && user.getPassword() != null
                && user.getAdmin() != null
                ? Valid(user)
                : Invalid(new ApplicationError("Wrong user creation", "Check user's informations", user, null)
        );
    }
}
