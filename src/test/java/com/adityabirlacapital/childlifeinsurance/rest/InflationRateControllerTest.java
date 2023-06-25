package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.service.InflationRateService;
import com.adityabirlacapital.childlifeinsurance.vo.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToAddInflationRate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
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
        InflationRateResponse inflationRateResponse1 = InflationRateResponse.builder()
                .inflationRateId(1)
                .inflationRate(4)
                .build();
        InflationRateResponse inflationRateResponse2 = InflationRateResponse.builder()
                .inflationRateId(2)
                .inflationRate(6)
                .build();

        given(inflationRateService.getInflationRates()).willReturn(List.of(inflationRateResponse1,inflationRateResponse2));
        mockMvc.perform(get("/oneappabc/adityabirla/api/v1/inflationrate")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].inflationRate", is(inflationRateResponse1.getInflationRate())));
    }
    @Test
    public void testGetInflationRateBadRequest() throws Exception {
        InflationRateResponse inflationRateResponse1 = InflationRateResponse.builder()
                .inflationRateId(1)
                .inflationRate(4)
                .build();
        InflationRateResponse inflationRateResponse2 = InflationRateResponse.builder()
                .inflationRateId(2)
                .inflationRate(6)
                .build();

        given(inflationRateService.getInflationRates()).willReturn(List.of(inflationRateResponse1,inflationRateResponse2));
        mockMvc.perform(get("/oneappabc/adityabirla/api/v1/badrequest")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
         }
    @Test
    public void testAddInflationRate() throws Exception {
        InflationRateResponse inflationRateResponse = InflationRateResponse.builder()
                .inflationRate(4)
                .inflationRateId(1)
                .build();

        RequestToAddInflationRate request = RequestToAddInflationRate.builder()
                        .inflationRate(4).build();
        given(inflationRateService.addInflationRates(request)).willReturn(inflationRateResponse);
        mockMvc.perform(post("/oneappabc/adityabirla/api/v1/inflationrate")
                        .contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", aMapWithSize(2)))
                .andDo(print());
    }

    @Test
    public void testAddInflationRateBadRequest() throws Exception {
        InflationRateResponse inflationRateResponse = InflationRateResponse.builder()
                .inflationRate(4)
                .inflationRateId(1)
                .build();

        RequestToAddInflationRate request = RequestToAddInflationRate.builder()
                .inflationRate(4).build();
        given(inflationRateService.addInflationRates(request)).willReturn(inflationRateResponse);
        mockMvc.perform(post("/oneappabc/adityabirla/api/v1/badrequest")
                        .contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());

    }
}
