/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.adityabirlacapital.childlifeinsurance.controller.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.controller.entity.Customer;
import com.adityabirlacapital.childlifeinsurance.controller.vo.RequestToSaveChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.controller.vo.ResponseToSaveChildPlanDetails;


/**
 * This will convert request object to entity object
 */
@Component
public class ChildPlanEntityMapper {
	
	/*
	 * convert to request object to child plan entity
	 */
	public ChildPlan mapToChildPlanEntity(RequestToSaveChildPlanDeatils request) {
		ChildPlan childPlan = new ChildPlan();
		
		Customer customer = new Customer();
		customer.setPersonId(request.getCustomerId());
		
		childPlan.setPersonId(customer);
		childPlan.setChildName(request.getChildName());
		
		childPlan.setChildAge(request.getChildAge());
		
		childPlan.setGoalType(request.getGoalType());
		
		childPlan.setGoalAmt(request.getGoalAmt());
		
		childPlan.setGoalTenure(request.getGoalTenure());
		
		childPlan.setRoi(request.getRoi());
		
		childPlan.setTenure(request.getTenure());
		
		childPlan.setCreatedBy(request.getCreatedBy());

		childPlan.setModifiedBy(request.getModifiedBy());
		
		childPlan.setCreatedDate(LocalDateTime.now());
		
		childPlan.setModifiedDate(LocalDateTime.now());
		
		return childPlan;
	}

	
	/*
	 * convert child plan entity to response object to 
	 */
	public ResponseToSaveChildPlanDetails mapToChildPlanResponse(ChildPlan childPlan) {
		ResponseToSaveChildPlanDetails response = new ResponseToSaveChildPlanDetails();
		
		response.setLiChildId(childPlan.getLiChildId());
		
		response.setCustomerId(childPlan.getPersonId().getPersonId());
		
		response.setChildName(childPlan.getChildName());
		
		response.setChildAge(childPlan.getChildAge());
		
		response.setGoalType(childPlan.getGoalType());
		
		response.setGoalAmt(childPlan.getGoalAmt());
		
		response.setGoalTenure(childPlan.getGoalTenure());
		
		response.setRoi(childPlan.getRoi());
		
		response.setTenure(childPlan.getTenure());
		
		response.setCreatedBy(childPlan.getCreatedBy());

		response.setModifiedBy(childPlan.getModifiedBy());
		
		response.setCreatedDate(LocalDateTime.now());
		
		response.setModifiedDate(LocalDateTime.now());
		
		response.setSaveAmount(childPlan.getSaveAmount());
		
		response.setExpensesFinal(childPlan.getExpensesFinal());
		
		return response;
	}
}
