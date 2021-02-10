package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import org.springframework.util.StringUtils;

import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new MemoryCustomerRepository();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        Customer newCustomer = new Customer.CustomerBuilder(
                capitalizeFirstLetter(customer.getFirstName()),
                capitalizeFirstLetter(customer.getLastName()),
                addDashAfterFour(customer.getPersonalNumber()))
                .age(customer.getAge())
                .city(customer.getCity())
                .countryCode(customer.getCountryCode())
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
        String capitalizeFirstLetter = "";
        if (str.length() > 0) {
            capitalizeFirstLetter = str.substring(0, 1).toUpperCase() + str.substring(1);
        }

        return capitalizeFirstLetter;
    }

    private String addDashAfterFour(String str) {
        String addedDash = str;
        if (str.length() > 4) {
            addedDash = str.substring(0, 4) + '-' + str.substring(4);
        }
        return addedDash;
    }


}
