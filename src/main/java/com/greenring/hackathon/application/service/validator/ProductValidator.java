package com.greenring.hackathon.application.service.validator;

import com.greenring.hackathon.application.ApplicationError;
import com.greenring.hackathon.domain.model.Product;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;

public interface ProductValidator {
    static Validation<ApplicationError, Product> validate(Product product){
        return product.get_id() != null && product.getPrice() != null && product.getName() != null
                ? Valid(product)
                : Invalid(new ApplicationError("Wrong product creation", "Check product's informations", product, null)
        );
    }
}

