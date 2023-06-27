package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToGetChildPlanDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class ChildPlantEntityMapperTest {

    @Autowired
    private ChildPlanEntityMapper childPlanEntityMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testMapToChildPlanEntity() throws IOException {
        // Set up the request object
        RequestToAddChildPlanDetails requestToAddChildPlanDeatils = objectMapper.readValue(getClass().getResourceAsStream("/json/RequestToAddChildPlanDetails.json"), RequestToAddChildPlanDetails.class);

        ChildPlan childPlan = childPlanEntityMapper.mapToChildPlanEntity(requestToAddChildPlanDeatils);
        Assertions.assertEquals(childPlan.getChildAge(),requestToAddChildPlanDeatils.getChildAge());
        Assertions.assertEquals(childPlan.getChildName(),requestToAddChildPlanDeatils.getChildName());
        Assertions.assertEquals(childPlan.getCreatedBy(),requestToAddChildPlanDeatils.getCreatedBy());
        Assertions.assertEquals(childPlan.getModifiedBy(),requestToAddChildPlanDeatils.getModifiedBy());
        Assertions.assertEquals(childPlan.getRoi(),requestToAddChildPlanDeatils.getRoi());
        Assertions.assertEquals(childPlan.getTenure(),requestToAddChildPlanDeatils.getTenure());
        Assertions.assertEquals(childPlan.getGoalAmt(),requestToAddChildPlanDeatils.getGoalAmt());
        Assertions.assertEquals(childPlan.getGoalType(),requestToAddChildPlanDeatils.getGoalType());
        Assertions.assertEquals(childPlan.getGoalTenure(),requestToAddChildPlanDeatils.getGoalTenure());
        Assertions.assertEquals(childPlan.getCustomer().getId(),requestToAddChildPlanDeatils.getCustomerId());
        Assertions.assertEquals(childPlan.getCreatedBy(),requestToAddChildPlanDeatils.getCreatedBy());
        Assertions.assertEquals(childPlan.getModifiedBy(),requestToAddChildPlanDeatils.getModifiedBy());

    }

    @Test
    public void testMapToAddChildPlanResponse() throws IOException {
        // Set up the request object
        ChildPlan childPlan = objectMapper.readValue(getClass().getResourceAsStream("/json/ChildPlanEntity.json"),ChildPlan.class);

        ResponseToAddChildPlanDetails responseToAddChildPlanDetails = childPlanEntityMapper.mapToAddChildPlanResponse(childPlan);
        Assertions.assertEquals(childPlan.getChildAge(),responseToAddChildPlanDetails.getChildAge());
        Assertions.assertEquals(childPlan.getChildName(),responseToAddChildPlanDetails.getChildName());
        Assertions.assertEquals(childPlan.isActive(),responseToAddChildPlanDetails.getActive());
        Assertions.assertEquals(childPlan.getCreatedBy(),responseToAddChildPlanDetails.getCreatedBy());
        Assertions.assertEquals(childPlan.getModifiedBy(),responseToAddChildPlanDetails.getModifiedBy());
        Assertions.assertEquals(childPlan.getRoi(),responseToAddChildPlanDetails.getRoi());
        Assertions.assertEquals(childPlan.getTenure(),responseToAddChildPlanDetails.getTenure());
        Assertions.assertEquals(childPlan.getGoalAmt(),responseToAddChildPlanDetails.getGoalAmt());
        Assertions.assertEquals(childPlan.getGoalType(),responseToAddChildPlanDetails.getGoalType());
        Assertions.assertEquals(childPlan.getGoalTenure(),responseToAddChildPlanDetails.getGoalTenure());
        Assertions.assertEquals(childPlan.getCustomer().getId(),responseToAddChildPlanDetails.getCustomerId());
        Assertions.assertEquals(childPlan.getSaveAmount(),responseToAddChildPlanDetails.getSaveAmount());
        Assertions.assertEquals(childPlan.getExpensesFinal(),responseToAddChildPlanDetails.getExpensesFinal());
        Assertions.assertEquals(childPlan.getLiChildId(),responseToAddChildPlanDetails.getLiChildId());
        Assertions.assertEquals(childPlan.getCreatedBy(),responseToAddChildPlanDetails.getCreatedBy());
        Assertions.assertEquals(childPlan.getModifiedBy(),responseToAddChildPlanDetails.getModifiedBy());

    }

    @Test
    public void testMapToGetChildPlanResponse() throws IOException {
        // Set up the request object
        ChildPlan childPlan = objectMapper.readValue(getClass().getResourceAsStream("/json/ChildPlanEntity.json"),ChildPlan.class);

        ResponseToGetChildPlanDetails responseToGetChildPlanDetails = childPlanEntityMapper.mapToGetChildPlanResponse(childPlan);
        Assertions.assertEquals(childPlan.getChildAge(),responseToGetChildPlanDetails.getChildAge());
        Assertions.assertEquals(childPlan.getChildName(),responseToGetChildPlanDetails.getChildName());
        Assertions.assertEquals(childPlan.isActive(),responseToGetChildPlanDetails.getActive());
        Assertions.assertEquals(childPlan.getCreatedBy(),responseToGetChildPlanDetails.getCreatedBy());
        Assertions.assertEquals(childPlan.getModifiedBy(),responseToGetChildPlanDetails.getModifiedBy());
        Assertions.assertEquals(childPlan.getRoi(),responseToGetChildPlanDetails.getRoi());
        Assertions.assertEquals(childPlan.getTenure(),responseToGetChildPlanDetails.getTenure());
        Assertions.assertEquals(childPlan.getGoalAmt(),responseToGetChildPlanDetails.getGoalAmt());
        Assertions.assertEquals(childPlan.getGoalType(),responseToGetChildPlanDetails.getGoalType());
        Assertions.assertEquals(childPlan.getGoalTenure(),responseToGetChildPlanDetails.getGoalTenure());
        Assertions.assertEquals(childPlan.getCustomer().getId(),responseToGetChildPlanDetails.getCustomerId());
        Assertions.assertEquals(childPlan.getSaveAmount(),responseToGetChildPlanDetails.getSaveAmount());
        Assertions.assertEquals(childPlan.getExpensesFinal(),responseToGetChildPlanDetails.getExpensesFinal());
        Assertions.assertEquals(childPlan.getLiChildId(),responseToGetChildPlanDetails.getLiChildId());
    }

    @Test
    public void testMapToGetChildPlanResponseList() throws IOException {
        // Set up the expected entity list
        List<ChildPlan> childPlanList = objectMapper.readValue(getClass().getResourceAsStream("/json/ChildPlanEntityList.json"), new TypeReference<List<ChildPlan>>() {
        });
        List<ResponseToGetChildPlanDetails> responseToGetChildPlanDetails = childPlanEntityMapper.mapToGetChildPlanResponse(childPlanList);
        Assertions.assertEquals(childPlanList.size(),responseToGetChildPlanDetails.size());
        Assertions.assertEquals(childPlanList.get(0).getChildAge(),responseToGetChildPlanDetails.get(0).getChildAge());
        Assertions.assertEquals(childPlanList.get(0).getChildName(),responseToGetChildPlanDetails.get(0).getChildName());
        Assertions.assertEquals(childPlanList.get(0).isActive(),responseToGetChildPlanDetails.get(0).getActive());
        Assertions.assertEquals(childPlanList.get(0).getCreatedBy(),responseToGetChildPlanDetails.get(0).getCreatedBy());
        Assertions.assertEquals(childPlanList.get(0).getModifiedBy(),responseToGetChildPlanDetails.get(0).getModifiedBy());
        Assertions.assertEquals(childPlanList.get(0).getRoi(),responseToGetChildPlanDetails.get(0).getRoi());
        Assertions.assertEquals(childPlanList.get(0).getTenure(),responseToGetChildPlanDetails.get(0).getTenure());
        Assertions.assertEquals(childPlanList.get(0).getGoalAmt(),responseToGetChildPlanDetails.get(0).getGoalAmt());
        Assertions.assertEquals(childPlanList.get(0).getGoalType(),responseToGetChildPlanDetails.get(0).getGoalType());
        Assertions.assertEquals(childPlanList.get(0).getGoalTenure(),responseToGetChildPlanDetails.get(0).getGoalTenure());
        Assertions.assertEquals(childPlanList.get(0).getCustomer().getId(),responseToGetChildPlanDetails.get(0).getCustomerId());
        Assertions.assertEquals(childPlanList.get(0).getSaveAmount(),responseToGetChildPlanDetails.get(0).getSaveAmount());
        Assertions.assertEquals(childPlanList.get(0).getExpensesFinal(),responseToGetChildPlanDetails.get(0).getExpensesFinal());
        Assertions.assertEquals(childPlanList.get(0).getLiChildId(),responseToGetChildPlanDetails.get(0).getLiChildId());

        Assertions.assertEquals(childPlanList.get(1).getChildAge(),responseToGetChildPlanDetails.get(1).getChildAge());
        Assertions.assertEquals(childPlanList.get(1).getChildName(),responseToGetChildPlanDetails.get(1).getChildName());
        Assertions.assertEquals(childPlanList.get(1).isActive(),responseToGetChildPlanDetails.get(1).getActive());
        Assertions.assertEquals(childPlanList.get(1).getCreatedBy(),responseToGetChildPlanDetails.get(1).getCreatedBy());
        Assertions.assertEquals(childPlanList.get(1).getModifiedBy(),responseToGetChildPlanDetails.get(1).getModifiedBy());
        Assertions.assertEquals(childPlanList.get(1).getRoi(),responseToGetChildPlanDetails.get(1).getRoi());
        Assertions.assertEquals(childPlanList.get(1).getTenure(),responseToGetChildPlanDetails.get(1).getTenure());
        Assertions.assertEquals(childPlanList.get(1).getGoalAmt(),responseToGetChildPlanDetails.get(1).getGoalAmt());
        Assertions.assertEquals(childPlanList.get(1).getGoalType(),responseToGetChildPlanDetails.get(1).getGoalType());
        Assertions.assertEquals(childPlanList.get(1).getGoalTenure(),responseToGetChildPlanDetails.get(1).getGoalTenure());
        Assertions.assertEquals(childPlanList.get(1).getCustomer().getId(),responseToGetChildPlanDetails.get(1).getCustomerId());
        Assertions.assertEquals(childPlanList.get(1).getSaveAmount(),responseToGetChildPlanDetails.get(1).getSaveAmount());
        Assertions.assertEquals(childPlanList.get(1).getExpensesFinal(),responseToGetChildPlanDetails.get(1).getExpensesFinal());
        Assertions.assertEquals(childPlanList.get(1).getLiChildId(),responseToGetChildPlanDetails.get(1).getLiChildId());

    }
}
