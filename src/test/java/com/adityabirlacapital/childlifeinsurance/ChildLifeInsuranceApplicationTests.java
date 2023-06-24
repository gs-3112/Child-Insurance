package com.adityabirlacapital.childlifeinsurance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChildLifeInsuranceApplicationTests {

	@Test
	void contextLoads() {
	}

}


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ChildPlanServiceTest {

    @Mock
    private ChildPlanRepositoy childPlanRepositoy;

    @Mock
    private ChildPlanEntityMapper childPlanEntityMapper;

    @InjectMocks
    private ChildPlanService childPlanService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveChildPlanDetails_Positive() {
        RequestToAddChildPlanDeatils request = new RequestToAddChildPlanDeatils();
        // Set up the request object

        ChildPlan requestEntity = new ChildPlan();
        // Set up the expected entity

        ResponseToAddChildPlanDetails expectedResponse = new ResponseToAddChildPlanDetails();
        // Set up the expected response

        when(childPlanEntityMapper.mapToChildPlanEntity(request)).thenReturn(requestEntity);
        when(childPlanRepositoy.save(requestEntity)).thenReturn(requestEntity);
        when(childPlanEntityMapper.mapToAddChildPlanResponse(requestEntity)).thenReturn(expectedResponse);

        ResponseToAddChildPlanDetails response = childPlanService.saveChildPlanDetails(request);

        // Assert the response object
        // ...
    }

    @Test
    public void testSaveChildPlanDetails_Negative() {
        RequestToAddChildPlanDeatils request = new RequestToAddChildPlanDeatils();
        // Set up the request object

        when(childPlanEntityMapper.mapToChildPlanEntity(request)).thenReturn(null);

        ResponseToAddChildPlanDetails response = childPlanService.saveChildPlanDetails(request);

        // Assert the response object
        // ...
    }

    @Test
    public void testGetChildPlanDetails_Positive() {
        Long customerId = 123L;

        List<ChildPlan> entityList = new ArrayList<>();
        // Set up the expected entity list

        List<ResponseToGetChildPlanDetails> expectedResponseList = new ArrayList<>();
        // Set up the expected response list

        when(childPlanRepositoy.findByCustomerId(customerId)).thenReturn(entityList);
        when(childPlanEntityMapper.mapToGetChildPlanEntity(entityList)).thenReturn(expectedResponseList);

        List<ResponseToGetChildPlanDetails> responseList = childPlanService.getChildPlanDetails(customerId);

        // Assert the response list
        // ...
    }

    @Test
    public void testGetChildPlanDetails_Negative() {
        Long customerId = 123L;

        when(childPlanRepositoy.findByCustomerId(customerId)).thenReturn(null);

        List<ResponseToGetChildPlanDetails> responseList = childPlanService.getChildPlanDetails(customerId);

        // Assert the response list
        // ...
    }
}
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ChildPlanController.class)
public class ChildPlanControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ChildPlanService childPlanService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ChildPlanController(childPlanService)).build();
    }

    @Test
    public void testAddChildLifeInsuranceDetails_Positive() throws Exception {
        RequestToAddChildPlanDeatils request = new RequestToAddChildPlanDeatils();
        // Set up the request object

        ResponseToAddChildPlanDetails response = new ResponseToAddChildPlanDetails();
        // Set up the expected response object

        when(childPlanService.saveChildPlanDetails(any(RequestToAddChildPlanDeatils.class))).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/oneappabc/adityabirla/api/v1/lifeinsurance/childplan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.convertObjectToJsonBytes(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.property").value("expectedValue"));
    }

    @Test
    public void testAddChildLifeInsuranceDetails_Negative() throws Exception {
        RequestToAddChildPlanDeatils request = new RequestToAddChildPlanDeatils();
        // Set up the request object

        when(childPlanService.saveChildPlanDetails(any(RequestToAddChildPlanDeatils.class))).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/oneappabc/adityabirla/api/v1/lifeinsurance/childplan")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.convertObjectToJsonBytes(request)))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    public void testGetChildPlanDetails_Positive() throws Exception {
        Long customerId = 123L;

        List<ResponseToGetChildPlanDetails> responseList = new ArrayList<>();
        // Set up the expected response list

        when(childPlanService.getChildPlanDetails(customerId)).thenReturn(responseList);

        mockMvc.perform(MockMvcRequestBuilders.get("/oneappabc/adityabirla/api/v1/lifeinsurance/childplan/{customerId}", customerId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(responseList.size()));
    }

    @Test
    public void testGetChildPlanDetails_Negative() throws Exception {
        Long customerId = 123L;

        when(childPlanService.getChildPlanDetails(customerId)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/oneappabc/adityabirla/api/v1/lifeinsurance/childplan/{customerId}", customerId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
