package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.dto.CalculatedResult;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDetails;
import org.springframework.stereotype.Service;


@Service
public class ChildPlanCalculator {
    public CalculatedResult calculate(RequestToAddChildPlanDetails request) {
        long projected_goal_cost;
        final double rate_of_return = 0.06;
        projected_goal_cost = (long) (request.getGoalAmt() * Math.pow((1 + request.getRoi() / 100), request.getGoalTenure()));
        long projected = (Long) roundFloor(projected_goal_cost);
        double t = request.getGoalTenure() - request.getTenure();
        double invested = Math.round(projected_goal_cost / (Math.pow((1 + rate_of_return), 1 * t)));
        long investfortillthisamt = (long) invested;
        //premium calculation
        double useDiscounting = roundAvoid(pmt(rate_of_return / 12, request.getTenure() * 12, 0, investfortillthisamt, 1), 2);
        long premiumRoundoff = roundCeil(useDiscounting);
        long coverAmount = 10 * (premiumRoundoff * 12);
        long coverAmountRoundOff = roundFloor(coverAmount);
        //---------------------------------------------------
        return CalculatedResult.builder()
                .projectedGoalCost(projected_goal_cost)
                .projectedGoalCostRoundOff(projected)
                .investForTillThisAmt(investfortillthisamt)
                .premiumAmtTobeInvestPerMonth(useDiscounting)
                .premiumAmtTobeInvestPerMonthRoundOff(premiumRoundoff)
                .coverAmount(coverAmount)
                .coverAmountRoundOff(coverAmountRoundOff)
                .build();
    }

    public static long roundFloor(double input) {
        long i = (long) Math.floor(input);
        return ((i - 9999) / 100000) * 100000;
    }

    public long roundCeil(double input) {
        long i = (long) Math.ceil(input);
        return ((i + 99) / 100) * 100;
    }

    static double pmt(double rate_of_return, double invest_for, double pv, long investfor, int type) {
        return rate_of_return * (pv * Math.pow(1 + rate_of_return, invest_for) + investfor) / ((1 + rate_of_return * type) * (Math.pow(1 + rate_of_return, invest_for) - 1));
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
