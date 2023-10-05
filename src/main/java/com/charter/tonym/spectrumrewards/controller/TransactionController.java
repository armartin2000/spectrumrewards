package com.charter.tonym.spectrumrewards.controller;


import com.charter.tonym.spectrumrewards.model.Transaction;
import com.charter.tonym.spectrumrewards.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/list")
    public Flux<Transaction> getAllTransactions() {
        return transactionService.getAllTransaction();
    }

    @GetMapping("/{transactionId}")
    public Mono<Transaction> getTransactionById(@PathVariable Long transactionId) {
        return transactionService.getTransactionById(transactionId);
    }
}
