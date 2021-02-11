package com.enorkus.academy.validator;

import com.enorkus.academy.exception.ValidationException;

import java.util.Locale;

public class CountryCodeValidator extends Validator<String>{

    public void validate(String str, String message) {
        if (str.length() > 0) {
            boolean isValid = true;
            for (CountryCode value : CountryCode.values()) {
                if (value.name().equals(str.toUpperCase(Locale.ROOT))) {
                    isValid = false;
                }
            }
            if (isValid) {
                throw new ValidationException(message);
            }
        }
    }
}
