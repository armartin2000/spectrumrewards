package com.charter.tonym.spectrumrewards.service;


import com.charter.tonym.spectrumrewards.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CustomerService {

    Flux<Customer> getAllCustomers();
    Mono<Customer> getCustomerById(Long id);
}
