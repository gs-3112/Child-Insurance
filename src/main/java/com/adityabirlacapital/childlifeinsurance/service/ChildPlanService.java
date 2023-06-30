/**
 *
 */
package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.dto.*;
import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.mapper.ChildPlanEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.ChildPlanRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Service processor for child plan 
 */
@Service
public class ChildPlanService {

    @Autowired
    private ChildPlanRepositoy childPlanRepositoy;
    @Autowired
    private ChildPlanEntityMapper childPlanEntityMapper;
    @Autowired
    private ChildPlanCalculator childPlanCalculator;

    public ChildPlan saveChildPlanDetails(RequestToAddChildPlanDetails request) {
        ChildPlan requestEntity = childPlanEntityMapper.mapToChildPlanEntity(request);
        CalculatedResult result = childPlanCalculator.calculate(request);
        // Calculator will calculate these values.
        requestEntity.setSaveAmount(result.getPremiumAmtTobeInvestPerMonthRoundOff());
        requestEntity.setExpensesFinal(result.getCoverAmountRoundOff());
        ChildPlan savedEntity = childPlanRepositoy.save(requestEntity);
//        ResponseToAddChildPlanDetails response = childPlanEntityMapper.mapToAddChildPlanResponse((savedEntity));
        return savedEntity;
    }

    public List<ChildPlan> getChildPlanDetails(Long customerId) {
        List<ChildPlan> entityList = childPlanRepositoy.findByCustomerId(customerId);
//        List<ResponseToGetChildPlanDetails> responseList = childPlanEntityMapper.mapToGetChildPlanResponse(entityList);
        return entityList;
    }

    public Integer updateChildPlanDtails(Long childPlanId, Boolean isInterestedInPlan) {
        return childPlanRepositoy.updateIfInterestedInPlan(childPlanId, isInterestedInPlan);
    }
}
