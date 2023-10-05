package com.charter.tonym.spectrumrewards.repository;

import com.charter.tonym.spectrumrewards.model.Customer;
import com.charter.tonym.spectrumrewards.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByCreatedBetweenAndCustomer(
            LocalDateTime createdTimeStart, LocalDateTime createdTimeEnd, Customer customer);
}
