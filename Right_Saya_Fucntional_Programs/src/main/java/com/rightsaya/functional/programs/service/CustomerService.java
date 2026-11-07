package com.rightsaya.functional.programs.service;

import com.rightsaya.functional.programs.dtos.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerService {

    public CompletableFuture<Customer> getCustomer(Long customerId) {

        return CompletableFuture.supplyAsync(() -> {

            System.out.println(
                    "Thread: " + Thread.currentThread().getName()
            );

            // Simulating DB / REST API call
            return new Customer(
                    customerId,
                    "Ritesh",
                    "ritesh@example.com",
                    "9876543210",
                    "Paonta Sahib",
                    "ACTIVE"
            );
        });
    }

    public Customer getCustomer(String email) {

            return new Customer(
                    200l,
                    "Ritesh",
                    email,
                    "9876543210",
                    "Paonta Sahib",
                    "ACTIVE");

    }

    public CompletableFuture<List<Customer>> getCustomers() {
        return null;
    }

    CompletableFuture<Customer> getCustomer(Long id, boolean bool) {
        return null;
    }
}
