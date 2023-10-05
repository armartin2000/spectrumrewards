package com.charter.tonym.spectrumrewards.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RewardTotalDTO {

    private Integer rewardPointTotal;
    private String totalPurchaseAmount;
    private Integer numberOfTransactions;

    @Builder
    public RewardTotalDTO(Integer rewardPointTotal, String totalPurchaseAmount, Integer numberOfTransactions) {
        this.rewardPointTotal = rewardPointTotal;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.numberOfTransactions = numberOfTransactions;
    }





}
