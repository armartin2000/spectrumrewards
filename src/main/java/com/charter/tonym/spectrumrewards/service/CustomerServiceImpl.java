package com.charter.tonym.spectrumrewards.service;

import com.charter.tonym.spectrumrewards.model.Customer;
import com.charter.tonym.spectrumrewards.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Flux<Customer> getAllCustomers() {
        return Flux.fromIterable(customerRepository.findAll());
    }

    @Override
    public Mono<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(Mono::just)
                .orElseGet(Mono::empty);
    }
}
