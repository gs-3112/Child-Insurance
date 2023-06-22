/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.service.ChildPlanService;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToSaveChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.vo.ResponseToSaveChildPlanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Endpoint controller for child plan module
 */
@RestController
@RequestMapping("oneappabc/adityabirla/api/v1/lifeinsurance/childplan")
public class ChildPlanController {

	@Autowired
	private ChildPlanService childPlanService;
	
	@PostMapping
	public ResponseEntity<ResponseToSaveChildPlanDetails> saveChildLifeInsuranceDtails(@RequestBody RequestToSaveChildPlanDeatils request) {
		ResponseToSaveChildPlanDetails response = childPlanService.saveChildPlanDetails(request);
		
		return new ResponseEntity<ResponseToSaveChildPlanDetails>(response,HttpStatus.CREATED);
	}
	
}
