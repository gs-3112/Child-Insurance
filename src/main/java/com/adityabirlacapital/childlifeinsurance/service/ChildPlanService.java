/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.entity.Customer;
import com.adityabirlacapital.childlifeinsurance.mapper.ChildPlanEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.ChildPlanRepositoy;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToAddChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.vo.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.vo.ResponseToGetChildPlanDetails;
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
	
	public ResponseToAddChildPlanDetails saveChildPlanDetails(RequestToAddChildPlanDeatils request) {
		ChildPlan requestEntity = childPlanEntityMapper.mapToChildPlanEntity(request);
		// Calculator will calculate these values.
//		requestEntity.setSaveAmount(10000d);
//		requestEntity.setExpensesFinal(3000d);
		ChildPlan savedEntity = childPlanRepositoy.save(requestEntity);
		ResponseToAddChildPlanDetails response = childPlanEntityMapper.mapToAddChildPlanResponse((savedEntity));
		return response;
	}

    public List<ResponseToGetChildPlanDetails> getChildPlanDetails(Long customerId) {
		List<ChildPlan> entityList = childPlanRepositoy.findByCustomerId(customerId);
		List<ResponseToGetChildPlanDetails> responseList = childPlanEntityMapper.mapToGetChildPlanEntity(entityList);
		return responseList;
    }
}
