package com.charter.tonym.spectrumrewards.controller;


import com.charter.tonym.spectrumrewards.model.Customer;
import com.charter.tonym.spectrumrewards.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Flux<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
