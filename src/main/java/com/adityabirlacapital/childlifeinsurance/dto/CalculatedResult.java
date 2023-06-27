package com.adityabirlacapital.childlifeinsurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CalculatedResult {

    private Long projectedGoalCost;
    private Long projectedGoalCostRoundOff;
    private Long investForTillThisAmt;
    private  Double premiumAmtTobeInvestPerMonth ;
    private Long premiumAmtTobeInvestPerMonthRoundOff;
    private  Long coverAmount ;
    private Long coverAmountRoundOff;

}
