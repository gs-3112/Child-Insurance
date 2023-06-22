/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.entity.Customer;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToSaveChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.vo.ResponseToSaveChildPlanDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * This will convert request object to entity object
 */
@Component
public class ChildPlanEntityMapper {
	
	/*
	 * convert to request object to child plan entity
	 */
	public ChildPlan mapToChildPlanEntity(RequestToSaveChildPlanDeatils request) {
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
				.active(request.getActive())
				.build();
		return childPlan;
	}

	
	/*
	 * convert child plan entity to response object to 
	 */
	public ResponseToSaveChildPlanDetails mapToChildPlanResponse(ChildPlan childPlan) {
		ResponseToSaveChildPlanDetails response = ResponseToSaveChildPlanDetails.builder()
				.liChildId(childPlan.getLiChildId())
				.customerId(childPlan.getCustomer().getId())
				.childName(childPlan.getChildName())
				.childAge(childPlan.getChildAge())
				.goalType(childPlan.getGoalType())
				.goalAmt(childPlan.getGoalAmt())
				.goalTenure(childPlan.getGoalTenure())
				.roi(childPlan.getRoi())
				.tenure(childPlan.getTenure())
				.createdBy(childPlan.getCreatedBy())
				.modifiedBy(childPlan.getModifiedBy())
				.createdDate(LocalDateTime.now())
				.modifiedDate(LocalDateTime.now())
				.active(childPlan.isActive())
				.build();
		return response;
	}
}
