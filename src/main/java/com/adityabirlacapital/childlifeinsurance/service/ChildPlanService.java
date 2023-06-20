/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adityabirlacapital.childlifeinsurance.controller.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.controller.vo.RequestToSaveChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.controller.vo.ResponseToSaveChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.mapper.ChildPlanEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.ChildPlanRepositoy;

/**
 * Service processor for child plan 
 */
@Service
public class ChildPlanService {

	@Autowired
	private ChildPlanRepositoy childPlanRepositoy;
	@Autowired
	private ChildPlanEntityMapper childPlanEntityMapper;
	
	public ResponseToSaveChildPlanDetails saveChildPlanDetails(RequestToSaveChildPlanDeatils request) {
		ChildPlan requestEntity = childPlanEntityMapper.mapToChildPlanEntity(request);
		// Calculator will calculate these values.
		requestEntity.setSaveAmount(10000d);
		requestEntity.setExpensesFinal(3000d);
		ChildPlan savedEntity = childPlanRepositoy.save(requestEntity);
		ResponseToSaveChildPlanDetails response = childPlanEntityMapper.mapToChildPlanResponse(savedEntity);
		return response;
	}

}
