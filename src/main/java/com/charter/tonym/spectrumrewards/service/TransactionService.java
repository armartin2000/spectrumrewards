package com.charter.tonym.spectrumrewards.service;

import com.charter.tonym.spectrumrewards.model.Customer;
import com.charter.tonym.spectrumrewards.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> getAllTransaction();

    Mono<Transaction> getTransactionById(Long id);

    Flux<Transaction> get30DayCustomerRewardsTotal(Customer customer);
}
