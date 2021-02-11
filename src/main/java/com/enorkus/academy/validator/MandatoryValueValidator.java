package com.enorkus.academy.validator;

import com.enorkus.academy.exception.ValidationException;

public class MandatoryValueValidator extends Validator<String> {

    @Override
    public void validate(String str, String message) {
        if (str.trim().isEmpty()) {
            throw new ValidationException(message);
        }
    }
}
