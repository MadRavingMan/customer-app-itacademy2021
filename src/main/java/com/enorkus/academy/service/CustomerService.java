package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validator.CustomerValidator;

import java.util.List;
import java.util.Locale;

public class CustomerService {

    CustomerRepository customerRepository;
    CustomerValidator customerValidator;

    public CustomerService() {
        customerValidator = new CustomerValidator();
        customerRepository = new MemoryCustomerRepository();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        customerValidator.validateCustomer(customer);
        Customer newCustomer = new Customer.CustomerBuilder(
                capitalizeFirstLetter(customer.getFirstName()),
                capitalizeFirstLetter(customer.getLastName()),
                addDashAfterFour(customer.getPersonalNumber()))
                .age(customer.getAge())
                .city(customer.getCity())
                .countryCode(customer.getCountryCode().toUpperCase(Locale.ROOT))
                .employer(customer.getEmployer())
                .gender(customer.getGender())
                .maritalStatus(customer.getMaritalStatus())
                .middleName(customer.getMiddleName())
                .monthlyIncome(customer.getMonthlyIncome())
                .build();

        customerRepository.insert(newCustomer);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private String capitalizeFirstLetter(String str) {
        if (str.length() > 0) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        } else {
            return str;
        }

    }

    private String addDashAfterFour(String str) {
        String addedDash = str;
        if (str.length() > 4) {
            if (str.charAt(4) != '-')
                addedDash = str.substring(0, 4) + '-' + str.substring(4);
        }
        return addedDash;
    }


}
