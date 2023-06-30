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
        CalculatedResult expectedResult = new CalculatedResult();
        expectedResult.setProjectedGoalCost(4382246l);
        expectedResult.setProjectedGoalCostRoundOff(4300000l);
        expectedResult.setInvestForTillThisAmt(2447023l);
        expectedResult.setPremiumAmtTobeInvestPerMonth(14857.57);
        expectedResult.setPremiumAmtTobeInvestPerMonthRoundOff(14900l);
        expectedResult.setCoverAmount(1788000l);
        expectedResult.setCoverAmountRoundOff(1700000l);

        RequestToAddChildPlanDetails request = new RequestToAddChildPlanDetails();
        request.setGoalAmt(2000000d);
        request.setGoalTenure(20d);
        request.setTenure(10d);
        request.setRoi(4d);

        CalculatedResult result = childPlanCalculator.calculate(request);

        Assertions.assertEquals(result.getProjectedGoalCost(),expectedResult.getProjectedGoalCost());
        Assertions.assertEquals(result.getProjectedGoalCostRoundOff(),expectedResult.getProjectedGoalCostRoundOff());
        Assertions.assertEquals(result.getInvestForTillThisAmt(),expectedResult.getInvestForTillThisAmt());
        Assertions.assertEquals(result.getPremiumAmtTobeInvestPerMonth(),expectedResult.getPremiumAmtTobeInvestPerMonth());
        Assertions.assertEquals(result.getPremiumAmtTobeInvestPerMonthRoundOff(),expectedResult.getPremiumAmtTobeInvestPerMonthRoundOff());
        Assertions.assertEquals(result.getCoverAmount(),expectedResult.getCoverAmount());
        Assertions.assertEquals(result.getCoverAmountRoundOff(),expectedResult.getCoverAmountRoundOff());
    }
}
