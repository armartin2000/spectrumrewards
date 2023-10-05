package com.charter.tonym.spectrumrewards.controller;


import com.charter.tonym.spectrumrewards.model.RewardTotalDTO;
import com.charter.tonym.spectrumrewards.service.MyRewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rewards")
public class MyRewardsController {

    private MyRewardsService myRewardsService;

    @Autowired
    public MyRewardsController(MyRewardsService myRewardsService) {
        this.myRewardsService = myRewardsService;
    }

    @GetMapping("/{customerId}")
    public Mono<RewardTotalDTO> getLast30RewardsTotal(@PathVariable Long customerId) {
        return myRewardsService.getCustomerRewardsTotal(customerId);
    }
}
