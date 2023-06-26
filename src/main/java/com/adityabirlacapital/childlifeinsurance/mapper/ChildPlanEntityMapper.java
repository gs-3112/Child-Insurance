/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.entity.Customer;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToGetChildPlanDetails;
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
	public ChildPlan mapToChildPlanEntity(RequestToAddChildPlanDeatils request) {
		Customer customer = Customer.builder()
				.id(request.getCustomerId())
				.build();

		ChildPlan childPlan = ChildPlan.builder()
				.customer(customer)
				.childName(request.getChildName())
				.childAge(request.getChildAge())
				.goalType(request.getGoalType())
				.goalAmt(request.getGoalAmt())
				.goalTenure(request.getGoalTenure())
				.roi(request.getRoi())
				.tenure(request.getTenure())
				.createdBy(request.getCreatedBy())
				.modifiedBy(request.getModifiedBy())
				.createdDate(LocalDateTime.now())
				.modifiedDate(LocalDateTime.now())
				.expensesFinal(request.getExpensesFinal())
				.saveAmount(request.getSaveAmount())
				.build();
		return childPlan;
	}

	
	/*
	 * convert child plan entity to response object to 
	 */
	public ResponseToAddChildPlanDetails mapToAddChildPlanResponse(ChildPlan childPlan) {
		ResponseToAddChildPlanDetails response = ResponseToAddChildPlanDetails.builder()
				.liChildId(childPlan.getLiChildId())
				.customerId(childPlan.getCustomer().getId())
				.childName(childPlan.getChildName())
				.childAge(childPlan.getChildAge())
				.goalType(childPlan.getGoalType())
				.goalAmt(childPlan.getGoalAmt())
				.goalTenure(childPlan.getGoalTenure())
				.roi(childPlan.getRoi())
				.tenure(childPlan.getTenure())
				.saveAmount(childPlan.getSaveAmount())
				.expensesFinal(childPlan.getExpensesFinal())
				.createdBy(childPlan.getCreatedBy())
				.modifiedBy(childPlan.getModifiedBy())
				.createdDate(LocalDateTime.now())
				.modifiedDate(LocalDateTime.now())
				.active(childPlan.isActive())
				.build();
		return response;
	}

	public ResponseToGetChildPlanDetails mapToGetChildPlanResponse(ChildPlan childPlan) {
		ResponseToGetChildPlanDetails response = ResponseToGetChildPlanDetails.builder()
				.liChildId(childPlan.getLiChildId())
				.customerId(childPlan.getCustomer().getId())
				.childName(childPlan.getChildName())
				.childAge(childPlan.getChildAge())
				.goalType(childPlan.getGoalType())
				.goalAmt(childPlan.getGoalAmt())
				.goalTenure(childPlan.getGoalTenure())
				.roi(childPlan.getRoi())
				.tenure(childPlan.getTenure())
				.saveAmount(childPlan.getSaveAmount())
				.expensesFinal(childPlan.getExpensesFinal())
				.createdBy(childPlan.getCreatedBy())
				.modifiedBy(childPlan.getModifiedBy())
				.createdDate(LocalDateTime.now())
				.modifiedDate(LocalDateTime.now())
				.active(childPlan.isActive())
				.build();
		return response;
	}

	public List<ResponseToGetChildPlanDetails> mapToGetChildPlanEntity(List<ChildPlan> list) {
		List<ResponseToGetChildPlanDetails> responseList = new ArrayList<>();
		for (ChildPlan entity:list) {
			responseList.add(mapToGetChildPlanResponse(entity));
		}
		return responseList;
	}
}
