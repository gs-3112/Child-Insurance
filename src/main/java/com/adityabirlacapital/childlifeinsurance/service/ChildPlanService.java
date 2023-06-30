/**
 *
 */
package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.dto.CalculatedResult;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToGetChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.mapper.ChildPlanEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.ChildPlanRepositoy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service processor for child plan 
 */
@Service
@Slf4j
public class ChildPlanService {

    @Autowired
    private ChildPlanRepositoy childPlanRepositoy;
    @Autowired
    private ChildPlanEntityMapper childPlanEntityMapper;
    @Autowired
    private ChildPlanCalculator childPlanCalculator;

    public ResponseToAddChildPlanDetails saveChildPlanDetails(RequestToAddChildPlanDetails request) {
        ChildPlan requestEntity = childPlanEntityMapper.mapToChildPlanEntity(request);
        CalculatedResult result = childPlanCalculator.calculate(request);
        // Calculator will calculate these values.
        requestEntity.setSaveAmount(result.getPremiumAmtTobeInvestPerMonthRoundOff());
        requestEntity.setExpensesFinal(result.getCoverAmountRoundOff());
        ChildPlan savedEntity = null;
        ResponseToAddChildPlanDetails response = null;
        try {
            savedEntity = childPlanRepositoy.save(requestEntity);
            response = childPlanEntityMapper.mapToAddChildPlanResponse((savedEntity));
        }catch(DataIntegrityViolationException ex){
            savedEntity = childPlanRepositoy.findByUniqueKey(request.getCustomerId(),request.getChildName(),request.getChildAge(),request.getGoalType(),request.getGoalAmt(),
                    request.getGoalTenure(),request.getRoi(),request.getTenure(),request.getCreatedBy(),request.getModifiedBy());
            log.info("Record already exist ");
            response = childPlanEntityMapper.mapToAddChildPlanResponse((savedEntity));
            response.setDuplicateRecord(true);
        }
        return response;
    }

    public List<ResponseToGetChildPlanDetails> getChildPlanDetails(Long customerId) {
        List<ChildPlan> entityList = childPlanRepositoy.findByCustomerId(customerId);
        List<ResponseToGetChildPlanDetails> responseList = childPlanEntityMapper.mapToGetChildPlanResponse(entityList);
        return responseList;
    }

    public Integer updateChildPlanDtails(Long childPlanId, Boolean isInterestedInPlan) {
        return childPlanRepositoy.updateIfInterestedInPlan(childPlanId, isInterestedInPlan);
    }
}
