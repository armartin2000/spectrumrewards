package com.charter.tonym.spectrumrewards.service;

import com.charter.tonym.spectrumrewards.model.RewardTotalDTO;
import reactor.core.publisher.Mono;

public interface MyRewardsService {

    Mono<RewardTotalDTO> getCustomerRewardsTotal(Long customerId);

}
