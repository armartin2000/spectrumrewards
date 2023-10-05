package com.charter.tonym.spectrumrewards.service;

import com.charter.tonym.spectrumrewards.model.Customer;
import com.charter.tonym.spectrumrewards.model.Product;
import com.charter.tonym.spectrumrewards.model.RewardTotalDTO;
import com.charter.tonym.spectrumrewards.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class MyRewardsServiceImpl implements MyRewardsService {

    private CustomerService customerService;
    private TransactionService transactionService;

    @Autowired
    public MyRewardsServiceImpl(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    @Override
    public Mono<RewardTotalDTO> getCustomerRewardsTotal(Long customerId) {
        return getCustomer(customerId)
                .flatMap( customer -> {
                    return getRewardsTotal(customer);
                });
    }

    private Mono<RewardTotalDTO> getRewardsTotal(Customer customer) {
        List<Transaction> transactionList = new ArrayList<>();
        transactionService.get30DayCustomerRewardsTotal(customer)
                .collectList()
                .subscribe(transactionList::addAll);

        Integer transactionCount = transactionList.size();
        List<Product> productsPurchased = getAllProducts(transactionList);
        Double productsSumUnitPrice = getSumProductsUnitPrice(productsPurchased);
        Integer rewardTotal = calculateRewardsPoints(productsSumUnitPrice);

        return Mono.just(
                RewardTotalDTO.builder()
                        .totalPurchaseAmount(convertDoubleToCurrencyFormat(productsSumUnitPrice))
                        .numberOfTransactions(transactionCount)
                        .rewardPointTotal(rewardTotal)
                        .build()
        );
    }

    private Mono<Customer> getCustomer(Long customerId) {
        return customerService.getCustomerById(customerId);
    }
    private List<Product> getAllProducts(List<Transaction> transactions) {
        List<Product> products = new ArrayList<>();

        transactions.stream()
                .forEach(transaction -> {
                    products.addAll(transaction.getProducts());
        });
        return products;
    }

    private Double getSumProductsUnitPrice(List<Product> products) {

        return products.stream()
                .map(value -> value.getUnitPrice())
                .reduce(0.0, (acc, next) -> {
                    return acc + next;}
                );
    }

    private String convertDoubleToCurrencyFormat(Double price) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(price);
    }

    private Integer calculateRewardsPoints(Double totalPurchaseAmount) {

        int less100 = (totalPurchaseAmount >= 50) ? 50 : 0;

        if(totalPurchaseAmount > 100) {
            int over100 = Double.valueOf(totalPurchaseAmount - 100).intValue();
            return less100 + (2 * over100);
        } else
            return less100;
    }



}
