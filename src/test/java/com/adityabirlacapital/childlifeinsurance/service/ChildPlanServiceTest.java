package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.dto.CalculatedResult;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.dto.ResponseToGetChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.mapper.ChildPlanEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.ChildPlanRepositoy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ChildPlanServiceTest {

    @MockBean
    private ChildPlanRepositoy childPlanRepositoy;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ChildPlanEntityMapper childPlanEntityMapper;
    @Autowired
    private ChildPlanService childPlanService;
    @MockBean
    private ChildPlanCalculator childPlanCalculator;

    @Test
    public void testSaveChildPlanDetails() throws IOException {
        // Set up the request object
        RequestToAddChildPlanDetails request = objectMapper.readValue(getClass().getResourceAsStream("/json/RequestToAddChildPlanDetails.json"), RequestToAddChildPlanDetails.class);
        // Set up the expected entity
        ChildPlan requestEntity = objectMapper.readValue(getClass().getResourceAsStream("/json/ChildPlanEntity.json"),ChildPlan.class);
        // Set up the expected response
        ResponseToAddChildPlanDetails expectedResponse = objectMapper.readValue(getClass().getResourceAsStream("/json/ResponseToAddChildPlanDetails.json"),ResponseToAddChildPlanDetails.class);
        CalculatedResult expectedResult = CalculatedResult.builder()
                .projectedGoalCost(4382246l)
                .projectedGoalCostRoundOff(4300000l)
                .investForTillThisAmt(2447023l)
                .premiumAmtTobeInvestPerMonth(14857.57)
                .premiumAmtTobeInvestPerMonthRoundOff(14900l)
                .coverAmount(1788000l)
                .coverAmountRoundOff(1700000l)
                .build();

        when(childPlanEntityMapper.mapToChildPlanEntity(request)).thenReturn(requestEntity);
        when(childPlanRepositoy.save(requestEntity)).thenReturn(requestEntity);
        when(childPlanEntityMapper.mapToAddChildPlanResponse(requestEntity)).thenReturn(expectedResponse);
        when(childPlanCalculator.calculate(request)).thenReturn(expectedResult);
        ResponseToAddChildPlanDetails response = childPlanService.saveChildPlanDetails(request);

        // Assert the response object
        Assertions.assertEquals(response.getLiChildId(),expectedResponse.getLiChildId());
        Assertions.assertEquals(response.getChildAge(),expectedResponse.getChildAge());
        Assertions.assertEquals(response.getChildName(),expectedResponse.getChildName());
        Assertions.assertEquals(response.getActive(),expectedResponse.getActive());
        Assertions.assertEquals(response.getCreatedBy(),expectedResponse.getCreatedBy());
        Assertions.assertEquals(response.getModifiedBy(),expectedResponse.getModifiedBy());
        Assertions.assertEquals(response.getRoi(),expectedResponse.getRoi());
        Assertions.assertEquals(response.getTenure(),expectedResponse.getTenure());
        Assertions.assertEquals(response.getGoalAmt(),expectedResponse.getGoalAmt());
        Assertions.assertEquals(response.getGoalType(),expectedResponse.getGoalType());
        Assertions.assertEquals(response.getGoalTenure(),expectedResponse.getGoalTenure());
        Assertions.assertEquals(response.getSaveAmount(),expectedResponse.getSaveAmount());
        Assertions.assertEquals(response.getExpensesFinal(),expectedResponse.getExpensesFinal());
        Assertions.assertEquals(response.getCustomerId(),expectedResponse.getCustomerId());
    }

    @Test
    public void testGetChildPlanDetails() throws IOException {

        Long customerId = 123L;
        // Set up the expected entity list
        List<ChildPlan> entityList = objectMapper.readValue(getClass().getResourceAsStream("/json/ResponseToGetChildPlanDetailsList.json"), new TypeReference<List<ChildPlan>>() {
        });
        // Set up the expected response list
        List<ResponseToGetChildPlanDetails> expectedResponseList = objectMapper.readValue(getClass().getResourceAsStream("/json/ResponseToGetChildPlanDetailsList.json"), new TypeReference<List<ResponseToGetChildPlanDetails>>() {
        });

        when(childPlanRepositoy.findByCustomerId(customerId)).thenReturn(entityList);
        when(childPlanEntityMapper.mapToGetChildPlanResponse(entityList)).thenReturn(expectedResponseList);

        List<ResponseToGetChildPlanDetails> responseList = childPlanService.getChildPlanDetails(customerId);

        // Assert the response list
        Assertions.assertEquals(responseList.size(),expectedResponseList.size());
        Assertions.assertEquals(responseList.get(0).getLiChildId(),expectedResponseList.get(0).getLiChildId());
        Assertions.assertEquals(responseList.get(0).getLiChildId(),expectedResponseList.get(0).getLiChildId());
        Assertions.assertEquals(responseList.get(0).getChildAge(),expectedResponseList.get(0).getChildAge());
        Assertions.assertEquals(responseList.get(0).getChildName(),expectedResponseList.get(0).getChildName());
        Assertions.assertEquals(responseList.get(0).getActive(),expectedResponseList.get(0).getActive());
        Assertions.assertEquals(responseList.get(0).getCreatedBy(),expectedResponseList.get(0).getCreatedBy());
        Assertions.assertEquals(responseList.get(0).getModifiedBy(),expectedResponseList.get(0).getModifiedBy());
        Assertions.assertEquals(responseList.get(0).getRoi(),expectedResponseList.get(0).getRoi());
        Assertions.assertEquals(responseList.get(0).getTenure(),expectedResponseList.get(0).getTenure());
        Assertions.assertEquals(responseList.get(0).getGoalAmt(),expectedResponseList.get(0).getGoalAmt());
        Assertions.assertEquals(responseList.get(0).getGoalType(),expectedResponseList.get(0).getGoalType());
        Assertions.assertEquals(responseList.get(0).getGoalTenure(),expectedResponseList.get(0).getGoalTenure());
        Assertions.assertEquals(responseList.get(0).getSaveAmount(),expectedResponseList.get(0).getSaveAmount());
        Assertions.assertEquals(responseList.get(0).getExpensesFinal(),expectedResponseList.get(0).getExpensesFinal());
        Assertions.assertEquals(responseList.get(0).getCustomerId(),expectedResponseList.get(0).getCustomerId());

        Assertions.assertEquals(responseList.get(1).getLiChildId(),expectedResponseList.get(1).getLiChildId());
        Assertions.assertEquals(responseList.get(1).getLiChildId(),expectedResponseList.get(1).getLiChildId());
        Assertions.assertEquals(responseList.get(1).getChildAge(),expectedResponseList.get(1).getChildAge());
        Assertions.assertEquals(responseList.get(1).getChildName(),expectedResponseList.get(1).getChildName());
        Assertions.assertEquals(responseList.get(1).getActive(),expectedResponseList.get(1).getActive());
        Assertions.assertEquals(responseList.get(1).getCreatedBy(),expectedResponseList.get(1).getCreatedBy());
        Assertions.assertEquals(responseList.get(1).getModifiedBy(),expectedResponseList.get(1).getModifiedBy());
        Assertions.assertEquals(responseList.get(1).getRoi(),expectedResponseList.get(1).getRoi());
        Assertions.assertEquals(responseList.get(1).getTenure(),expectedResponseList.get(1).getTenure());
        Assertions.assertEquals(responseList.get(1).getGoalAmt(),expectedResponseList.get(1).getGoalAmt());
        Assertions.assertEquals(responseList.get(1).getGoalType(),expectedResponseList.get(1).getGoalType());
        Assertions.assertEquals(responseList.get(1).getGoalTenure(),expectedResponseList.get(1).getGoalTenure());
        Assertions.assertEquals(responseList.get(1).getSaveAmount(),expectedResponseList.get(1).getSaveAmount());
        Assertions.assertEquals(responseList.get(1).getExpensesFinal(),expectedResponseList.get(1).getExpensesFinal());
        Assertions.assertEquals(responseList.get(1).getCustomerId(),expectedResponseList.get(1).getCustomerId());
    }

    @Test
    public void testGetChildPlanDetails_Negative() {
        Long customerId = 123L;
        when(childPlanRepositoy.findByCustomerId(customerId)).thenReturn(List.of());
        List<ResponseToGetChildPlanDetails> responseList = childPlanService.getChildPlanDetails(customerId);
        // Assert the response list
        Assertions.assertNotNull(responseList);
        Assertions.assertEquals(responseList.size(),0);
    }
}