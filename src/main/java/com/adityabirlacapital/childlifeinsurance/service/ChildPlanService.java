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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	
	public ResponseToAddChildPlanDetails saveChildPlanDetails(RequestToAddChildPlanDetails request) {
		ChildPlan requestEntity = childPlanEntityMapper.mapToChildPlanEntity(request);
		CalculatedResult result = childPlanCalculator.calculate(request);
		// Calculator will calculate these values.
		requestEntity.setSaveAmount(result.getPremiumAmtTobeInvestPerMonthRoundOff());
		requestEntity.setExpensesFinal(result.getCoverAmountRoundOff());
		ChildPlan savedEntity = childPlanRepositoy.save(requestEntity);
		ResponseToAddChildPlanDetails response = childPlanEntityMapper.mapToAddChildPlanResponse((savedEntity));
		return response;
	}

    public List<ResponseToGetChildPlanDetails> getChildPlanDetails(Long customerId) {
		List<ChildPlan> entityList = childPlanRepositoy.findByCustomerId(customerId);
		List<ResponseToGetChildPlanDetails> responseList = childPlanEntityMapper.mapToGetChildPlanResponse(entityList);
		return responseList;
    }
}
