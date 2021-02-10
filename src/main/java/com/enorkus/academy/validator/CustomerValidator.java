package com.enorkus.academy.validator;

import com.enorkus.academy.exception.MandatoryValueMissingException;

public class CustomerValidator {

    public void validateMandatoryValues(String firstName, String lastName, String personalNumber) {

        if (firstName.trim().isEmpty()) {
            throw new MandatoryValueMissingException("First name is missing.");
        } else if (lastName.trim().isEmpty()) {
            throw new MandatoryValueMissingException("Last name is missing.");
        } else if (personalNumber.trim().isEmpty()) {
            throw new MandatoryValueMissingException("Personal number is missing.");
        }
    }

    private void validateMandatoryValues(String firstName, String lastName) {

    }
}
