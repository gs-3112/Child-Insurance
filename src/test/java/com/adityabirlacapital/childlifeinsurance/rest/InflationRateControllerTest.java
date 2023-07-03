package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.service.InflationRateService;
import com.adityabirlacapital.childlifeinsurance.dto.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddInflationRate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(InflationRateController.class)
public class InflationRateControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private InflationRateController inflationRateController;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private InflationRateService inflationRateService;
    @Test
    public void contextLoads() throws Exception {
        AssertionsForClassTypes.assertThat(inflationRateController).isNotNull();
    }

    @Test
    public void tesGetInflationRate() throws Exception {
        InflationRateResponse inflationRateResponse1 = new InflationRateResponse();
        inflationRateResponse1.setInflationRate(4);
        inflationRateResponse1.setInflationRateId(1);
        inflationRateResponse1.setCreatedBy("Admin");
        inflationRateResponse1.setModifiedBy("Admin");
        inflationRateResponse1.setCreatedDate(LocalDateTime.now());
        inflationRateResponse1.setModifiedDate(LocalDateTime.now());
        inflationRateResponse1.setActive(true);

        InflationRateResponse inflationRateResponse2 = new InflationRateResponse();
        inflationRateResponse2.setInflationRate(6);
        inflationRateResponse2.setInflationRate(2);
        inflationRateResponse2.setCreatedBy("Admin");
        inflationRateResponse2.setModifiedBy("Admin");
        inflationRateResponse2.setCreatedDate(LocalDateTime.now());
        inflationRateResponse2.setModifiedDate(LocalDateTime.now());
        inflationRateResponse2.setActive(true);

        given(inflationRateService.getInflationRates()).willReturn(List.of(inflationRateResponse1,inflationRateResponse2));
        mockMvc.perform(get("/oneappabc/adityabirla/api/v1/inflationrate")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetInflationRateBadRequest() throws Exception {
        InflationRateResponse inflationRateResponse1 = new InflationRateResponse();
        inflationRateResponse1.setInflationRate(4);
        inflationRateResponse1.setInflationRateId(1);
        inflationRateResponse1.setCreatedBy("Admin");
        inflationRateResponse1.setModifiedBy("Admin");
        inflationRateResponse1.setCreatedDate(LocalDateTime.now());
        inflationRateResponse1.setModifiedDate(LocalDateTime.now());
        inflationRateResponse1.setActive(true);

        InflationRateResponse inflationRateResponse2 = new InflationRateResponse();
        inflationRateResponse2.setInflationRate(6);
        inflationRateResponse2.setInflationRate(2);
        inflationRateResponse2.setCreatedBy("Admin");
        inflationRateResponse2.setModifiedBy("Admin");
        inflationRateResponse2.setCreatedDate(LocalDateTime.now());
        inflationRateResponse2.setModifiedDate(LocalDateTime.now());
        inflationRateResponse2.setActive(true);

        given(inflationRateService.getInflationRates()).willReturn(List.of(inflationRateResponse1,inflationRateResponse2));
        mockMvc.perform(get("/oneappabc/adityabirla/api/v1/badrequest")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
         }
    @Test
    public void testAddInflationRate() throws Exception {
        InflationRateResponse inflationRateResponse = new InflationRateResponse();
        inflationRateResponse.setInflationRate(4);
        inflationRateResponse.setInflationRateId(1);
        inflationRateResponse.setCreatedBy("Admin");
        inflationRateResponse.setModifiedBy("Admin");
        inflationRateResponse.setCreatedDate(LocalDateTime.now());
        inflationRateResponse.setModifiedDate(LocalDateTime.now());
        inflationRateResponse.setActive(true);

        RequestToAddInflationRate request = new RequestToAddInflationRate();
        request.setInflationRate(4);
        request.setCreatedBy("Admin");
        request.setModifiedBy("Admin");

        given(inflationRateService.addInflationRates(request)).willReturn(inflationRateResponse);
        mockMvc.perform(post("/oneappabc/adityabirla/api/v1/inflationrate")
                        .contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testAddInflationRateBadRequest() throws Exception {
        InflationRateResponse inflationRateResponse = new InflationRateResponse();
        inflationRateResponse.setInflationRate(4);
        inflationRateResponse.setInflationRateId(1);
        inflationRateResponse.setCreatedBy("Admin");
        inflationRateResponse.setModifiedBy("Admin");
        inflationRateResponse.setCreatedDate(LocalDateTime.now());
        inflationRateResponse.setModifiedDate(LocalDateTime.now());
        inflationRateResponse.setActive(true);

        RequestToAddInflationRate request = new RequestToAddInflationRate();
        request.setInflationRate(4);
        given(inflationRateService.addInflationRates(request)).willReturn(inflationRateResponse);
        mockMvc.perform(post("/oneappabc/adityabirla/api/v1/badrequest")
                        .contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());

    }
}
