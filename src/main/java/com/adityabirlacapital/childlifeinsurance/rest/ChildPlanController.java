/**
 *
 */
package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.dto.*;
import com.adityabirlacapital.childlifeinsurance.service.ChildPlanService;
import com.adityabirlacapital.childlifeinsurance.util.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


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
        return new ResponseHandler().generateSuccessResponse(response,response.getDuplicateRecord()?HttpStatus.OK:HttpStatus.CREATED,response.getDuplicateRecord()?"Record already exist":Constants.SAVED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getChildPlanDetails(@NotNull(message = "customerId should not be null") @PathVariable("customerId") Long customerId) {
        List<ResponseToGetChildPlanDetails> responseList = childPlanService.getChildPlanDetails(customerId);
        return new ResponseHandler().generateSuccessResponse(responseList, HttpStatus.OK,Constants.SUCCESS);
    }

    @PatchMapping
    public ResponseEntity<Object> patchChildPlanDetails(@RequestBody RequestToUpdateChildPlan request) throws Exception {
        Integer count = childPlanService.updateChildPlanDtails(request);
        if(Optional.of(count).isPresent() && count == 0){
            return new ResponseHandler().generateFailureResponse(HttpStatus.NOT_FOUND,Constants.NOT_UPDATED,null);
        }
        return new ResponseHandler().generateSuccessResponse(HttpStatus.OK, Constants.UPDATED);
    }

}
