package com.adityabirlacapital.childlifeinsurance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.adityabirlacapital.childlifeinsurance.rest.InflationRateController;
import com.adityabirlacapital.childlifeinsurance.vo.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToAddInflationRate;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@SpringBootTest
@AutoConfigureMockMvc
public class InflationRateControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private InflationRateController inflationRateController;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void contextLoads() throws Exception {
        AssertionsForClassTypes.assertThat(inflationRateController).isNotNull();
    }

    @Test
    public void getInflationRateTest() throws Exception {
        InflationRateResponse inflationRateResponse1 = InflationRateResponse.builder()
                .inflationRateId(1)
                .inflationRate(4)
                .build();
        InflationRateResponse inflationRateResponse2 = InflationRateResponse.builder()
                .inflationRateId(2)
                .inflationRate(6)
                .build();

        given(inflationRateController.getInflationRate()).willReturn(List.of(inflationRateResponse1,inflationRateResponse2));
        mockMvc.perform(get("/oneappabc/adityabirla/api/v1/inflationrate")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].inflationRate", is(inflationRateResponse1.getInflationRate())));
    }

    @Test
    public void addInflationRateTest() throws Exception {
        InflationRateResponse inflationRateResponse = InflationRateResponse.builder()
                .inflationRate(4)
                .inflationRateId(1)
                .build();

        RequestToAddInflationRate request = RequestToAddInflationRate.builder()
                        .inflationRate(4).build();
        ResponseEntity<InflationRateResponse> response =  new ResponseEntity<>(inflationRateResponse, HttpStatus.CREATED);
        given(inflationRateController.addInflationRate(request)).willReturn(response);
        mockMvc.perform(post("/oneappabc/adityabirla/api/v1/inflationrate")
                        .contentType(APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", aMapWithSize(2)))
                .andDo(print());
    }
}
