/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToGetChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.entity.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * This will convert request object to entity object
 */
@Component
public class ChildPlanEntityMapper {
	
	/*
	 * convert to request object to child plan entity
	 */
	public ChildPlan mapToChildPlanEntity(RequestToAddChildPlanDetails request) {
		Customer customer = new Customer();
		customer.setId(request.getCustomerId());

		ChildPlan childPlan = new ChildPlan();
		childPlan.setCustomer(customer);
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
	public ResponseToAddChildPlanDetails mapToAddChildPlanResponse(ChildPlan childPlan) {
		ResponseToAddChildPlanDetails response = new ResponseToAddChildPlanDetails();
		response.setLiChildId(childPlan.getLiChildId());
		response.setCustomerId(childPlan.getCustomer().getId());
		response.setChildName(childPlan.getChildName());
		response.setChildAge(childPlan.getChildAge());
		response.setGoalType(childPlan.getGoalType());
		response.setGoalAmt(childPlan.getGoalAmt());
		response.setGoalTenure(childPlan.getGoalTenure());
		response.setRoi(childPlan.getRoi());
		response.setTenure(childPlan.getTenure());
		response.setExpensesFinal(childPlan.getExpensesFinal());
		response.setSaveAmount(childPlan.getSaveAmount());
		response.setCreatedBy(childPlan.getCreatedBy());
		response.setModifiedBy(childPlan.getModifiedBy());
		response.setCreatedDate(LocalDateTime.now());
		response.setModifiedDate(LocalDateTime.now());
		response.setActive(childPlan.isActive());
		return response;
	}

	public ResponseToGetChildPlanDetails mapToGetChildPlanResponse(ChildPlan childPlan) {
		ResponseToGetChildPlanDetails response = new ResponseToGetChildPlanDetails();
		response.setLiChildId(childPlan.getLiChildId());
		response.setCustomerId(childPlan.getCustomer().getId());
		response.setChildName(childPlan.getChildName());
		response.setChildAge(childPlan.getChildAge());
		response.setGoalType(childPlan.getGoalType());
		response.setGoalAmt(childPlan.getGoalAmt());
		response.setGoalTenure(childPlan.getGoalTenure());
		response.setRoi(childPlan.getRoi());
		response.setTenure(childPlan.getTenure());
		response.setExpensesFinal(childPlan.getExpensesFinal());
		response.setSaveAmount(childPlan.getSaveAmount());
		response.setCreatedBy(childPlan.getCreatedBy());
		response.setModifiedBy(childPlan.getModifiedBy());
		response.setCreatedDate(LocalDateTime.now());
		response.setModifiedDate(LocalDateTime.now());
		response.setActive(childPlan.isActive());
		return response;
	}

	public List<ResponseToGetChildPlanDetails> mapToGetChildPlanResponse(List<ChildPlan> list) {
		List<ResponseToGetChildPlanDetails> responseList = new ArrayList<>();
		for (ChildPlan entity:list) {
			responseList.add(mapToGetChildPlanResponse(entity));
		}
		return responseList;
	}
}
