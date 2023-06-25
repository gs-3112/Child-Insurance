package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.rest.ChildPlanController;
import com.adityabirlacapital.childlifeinsurance.service.ChildPlanService;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToAddChildPlanDeatils;
import com.adityabirlacapital.childlifeinsurance.vo.ResponseToAddChildPlanDetails;
import com.adityabirlacapital.childlifeinsurance.vo.ResponseToGetChildPlanDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(ChildPlanController.class)
@AutoConfigureMockMvc
public class ChildPlanControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ChildPlanController childPlanController;
    @MockBean
    private ChildPlanService childPlanService;


    @Test
    public void testAddChildLifeInsuranceDetails() throws Exception {
        // Set up the request object
        RequestToAddChildPlanDeatils request = objectMapper.readValue(getClass().getResourceAsStream("/json/RequestToAddChildPlanDetails.json"),RequestToAddChildPlanDeatils.class);

        // Set up the expected response object
        ResponseToAddChildPlanDetails expectedResponse = objectMapper.readValue(getClass().getResourceAsStream("/json/ResponseToAddChildPlanDetails.json"),ResponseToAddChildPlanDetails.class);

        when(childPlanService.saveChildPlanDetails(request)).thenReturn(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/oneappabc/adityabirla/api/v1/lifeinsurance/childplan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.childName").value(expectedResponse.getChildName()));
    }

    @Test
    public void testAddChildLifeInsuranceDetails_BadRequest() throws Exception {
        RequestToAddChildPlanDeatils request = new RequestToAddChildPlanDeatils();
        when(childPlanService.saveChildPlanDetails(any(RequestToAddChildPlanDeatils.class))).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/oneappabc/adityabirla/api/v1/lifeinsurance/badrequest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testGetChildPlanDetails() throws Exception {
        Long customerId = 123L;
        // Set up the expected response list
        List<ResponseToGetChildPlanDetails> expectedResponseList = objectMapper.readValue(getClass().getResourceAsStream("/json/ResponseToGetChildPlanDetailsList.json"), new TypeReference<List<ResponseToGetChildPlanDetails>>() {
        });
        when(childPlanService.getChildPlanDetails(customerId)).thenReturn(expectedResponseList);

        mockMvc.perform(MockMvcRequestBuilders.get("/oneappabc/adityabirla/api/v1/lifeinsurance/childplan/{customerId}", customerId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(expectedResponseList.size()));
    }

    @Test
    public void testGetChildPlanDetails_BadRequest() throws Exception {
        Long customerId = 123L;

        when(childPlanService.getChildPlanDetails(customerId)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/oneappabc/adityabirla/api/v1/lifeinsurance/badrequest/{customerId}", customerId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}