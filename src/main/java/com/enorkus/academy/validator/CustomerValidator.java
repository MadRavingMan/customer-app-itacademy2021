package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.CustomerNotAdultException;
import com.enorkus.academy.exception.InvalidCountryCodeException;
import com.enorkus.academy.exception.MandatoryValueMissingException;

import java.util.Locale;

public class CustomerValidator {

    public void validateCustomer(Customer customer) {
        validateMandatoryValues(customer.getFirstName(), customer.getLastName(), customer.getPersonalNumber());
        validateAge(customer.getAge());
        validateCountryCode(customer.getCountryCode());

    }

    private void validateMandatoryValues(String firstName, String lastName, String personalNumber) {

        if (firstName.trim().isEmpty()) {
            throw new MandatoryValueMissingException("First name is missing!");
        } else if (lastName.trim().isEmpty()) {
            throw new MandatoryValueMissingException("Last name is missing!");
        } else if (personalNumber.trim().isEmpty()) {
            throw new MandatoryValueMissingException("Personal number is missing!");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new CustomerNotAdultException("Customer must be 18 or older!");
        }
    }

    private void validateCountryCode(String str) {
        if (str.length() > 0) {
            boolean isValid = true;
            for (CountryCode value : CountryCode.values()) {
                if (value.name().equals(str.toUpperCase(Locale.ROOT))) {
                    isValid = false;
                }
            }
            if (isValid) {
                throw new InvalidCountryCodeException("Invalid country code!");
            }
        }
    }

}
