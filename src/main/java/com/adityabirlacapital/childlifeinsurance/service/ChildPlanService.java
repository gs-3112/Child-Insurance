/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.mapper.ChildPlanEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.ChildPlanRepositoy;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToSaveChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.vo.ResponseToSaveChildPlanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		//Just for testing to check weather one to many is working or not.
		//List<ChildPlan> list = childPlanRepositoy.findAll();
		ResponseToSaveChildPlanDetails response = childPlanEntityMapper.mapToChildPlanResponse(savedEntity);
		return response;
	}

}
