/**
 *
 */
package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseHandler;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToGetChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.service.ChildPlanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Object> addChildLifeInsuranceDetails(@Valid @RequestBody RequestToAddChildPlanDetails request) {
        ResponseToAddChildPlanDetails response = childPlanService.saveChildPlanDetails(request);
        return new ResponseHandler().generateSuccessResponse(response,response.getDuplicateRecord()?HttpStatus.FOUND:HttpStatus.CREATED,response.getDuplicateRecord()?"Record already exist":"Saved Successfully");
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getChildPlanDetails(@NotNull(message = "customerId should not be null") @PathVariable("customerId") Long customerId) {
        List<ResponseToGetChildPlanDetails> responseList = childPlanService.getChildPlanDetails(customerId);
        return new ResponseHandler().generateSuccessResponse(responseList, HttpStatus.OK,"Success");
    }

    @PatchMapping("/{childPlanId}")
    public ResponseEntity<Object> patchChildPlanDetails(@PathVariable("childPlanId") Long childPlanId,@RequestParam("isInterestedInPlan") Boolean isInterestedInPlan) throws Exception {
        Integer count = childPlanService.updateChildPlanDtails(childPlanId,isInterestedInPlan);
        return new ResponseHandler().generateSuccessResponse(HttpStatus.OK,"Updated Successfully");
    }


}
