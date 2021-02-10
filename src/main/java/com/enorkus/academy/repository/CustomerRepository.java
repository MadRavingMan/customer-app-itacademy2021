package com.enorkus.academy.repository;

import com.enorkus.academy.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    public default List<Customer> findAll() {
        return null;
    }

    public default void insert(Customer customer) {
    }

    public default void deleteById(String customerId) {

    }
}
