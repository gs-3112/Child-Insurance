package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.dto.CalculatedResult;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChildPlanCalculatorTest {

    @Autowired
    private ChildPlanCalculator childPlanCalculator;

    @Test
    public void calculateTest(){
        CalculatedResult expectedResult = CalculatedResult.builder()
                .projectedGoalCost(4382246l)
                .projectedGoalCostRoundOff(4300000l)
                .investForTillThisAmt(2447023l)
                .premiumAmtTobeInvestPerMonth(14857.57)
                .premiumAmtTobeInvestPerMonthRoundOff(14900l)
                .coverAmount(1788000l)
                .coverAmountRoundOff(1700000l)
                .build();

        RequestToAddChildPlanDetails request = RequestToAddChildPlanDetails.builder()
                .goalAmt(2000000d)
                .goalTenure(20d)
                .tenure(10d)
                .roi(4d)
                .build();
        CalculatedResult result = childPlanCalculator.calculate(request);
        System.out.println(result.toString());
        Assertions.assertEquals(result.getProjectedGoalCost(),expectedResult.getProjectedGoalCost());
        Assertions.assertEquals(result.getProjectedGoalCostRoundOff(),expectedResult.getProjectedGoalCostRoundOff());
        Assertions.assertEquals(result.getInvestForTillThisAmt(),expectedResult.getInvestForTillThisAmt());
        Assertions.assertEquals(result.getPremiumAmtTobeInvestPerMonth(),expectedResult.getPremiumAmtTobeInvestPerMonth());
        Assertions.assertEquals(result.getPremiumAmtTobeInvestPerMonthRoundOff(),expectedResult.getPremiumAmtTobeInvestPerMonthRoundOff());
        Assertions.assertEquals(result.getCoverAmount(),expectedResult.getCoverAmount());
        Assertions.assertEquals(result.getCoverAmountRoundOff(),expectedResult.getCoverAmountRoundOff());
    }
}
