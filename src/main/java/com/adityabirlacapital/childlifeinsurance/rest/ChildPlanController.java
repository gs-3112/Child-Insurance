/**
 *
 */
package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.service.ChildPlanService;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToGetChildPlanDetails;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Endpoint controller for child plan module
 */
@RestController
@RequestMapping("oneappabc/adityabirla/api/v1/lifeinsurance/childplan")
public class ChildPlanController {
    @Autowired
    private ChildPlanService childPlanService;
    @Autowired
    private Validator validator;

    @PostMapping
    public ResponseEntity<ResponseToAddChildPlanDetails> addChildLifeInsuranceDetails(@Valid @RequestBody RequestToAddChildPlanDeatils request) {
        ResponseToAddChildPlanDetails response = childPlanService.saveChildPlanDetails(request);
        return new ResponseEntity<ResponseToAddChildPlanDetails>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<ResponseToGetChildPlanDetails>> getChildPlanDtails(@NotNull(message = "customerId should not be null") @PathVariable("customerId") Long customerId) {
        List<ResponseToGetChildPlanDetails> responseList = childPlanService.getChildPlanDetails(customerId);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
