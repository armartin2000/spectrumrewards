package com.charter.tonym.spectrumrewards.service;

import com.charter.tonym.spectrumrewards.model.Customer;
import com.charter.tonym.spectrumrewards.model.Transaction;
import com.charter.tonym.spectrumrewards.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public Flux<Transaction> getAllTransaction() {
        return Flux.fromIterable(transactionRepository.findAll());
    }

    @Override
    public Mono<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .map(Mono::just)
                .orElseGet(Mono::empty);
    }

    @Override
    public Flux<Transaction> get30DayCustomerRewardsTotal(Customer customer) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lessThirtyDays = now.minusDays(30);

        return Flux.fromIterable(
                transactionRepository.findAllByCreatedBetweenAndCustomer(lessThirtyDays, now, customer));
    }

}
