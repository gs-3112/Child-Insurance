package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.mapper.InflationRateEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.InflationRateRepository;
import com.adityabirlacapital.childlifeinsurance.dto.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddInflationRate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class InflationRateServiceTest {

    @MockBean
    private InflationRateRepository inflationRateRepository;
    @MockBean
    private InflationRateEntityMapper inflationRateEntityMapper;
    @Autowired
    private InflationRateService inflationRateService;

    @Test
    public void testAddInflationRates() throws IOException {
        // Set up the request object
        RequestToAddInflationRate request = RequestToAddInflationRate.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .build();
        // Set up the requested entity
        InflationRate requestedEntity = InflationRate.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .inflationRateId(1)
                .build();
        // Set up the expected entity
        InflationRate expectedEntity = InflationRate.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .inflationRateId(1)
                .build();
        // Set up the expected response
        InflationRateResponse expectedResponse = InflationRateResponse.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .inflationRateId(1)
                .build();
        when(inflationRateEntityMapper.mapToInflationRateEntity(request)).thenReturn(requestedEntity);
        when(inflationRateRepository.save(requestedEntity)).thenReturn(expectedEntity);
        when(inflationRateEntityMapper.mapToInflationRateResponse(expectedEntity)).thenReturn(expectedResponse);

        InflationRateResponse response = inflationRateService.addInflationRates(request);
        // Assert the response object
        Assertions.assertEquals(response.getInflationRate(),expectedResponse.getInflationRate());
        Assertions.assertEquals(response.getInflationRateId(),expectedResponse.getInflationRateId());
        Assertions.assertEquals(response.getActive(),expectedResponse.getActive());
        Assertions.assertEquals(response.getCreatedBy(),expectedResponse.getCreatedBy());
        Assertions.assertEquals(response.getModifiedBy(),expectedResponse.getModifiedBy());
    }

    @Test
    public void testGetInflationRates() throws IOException {
        // Set up the expected entity
        List<InflationRate> expectedEntityList = List.of(InflationRate.builder()
                        .inflationRate(4)
                        .inflationRateId(1)
                        .createdBy("Sagar")
                        .modifiedBy("Sagar")
                        .active(true)
                        .build(),
                InflationRate.builder()
                        .inflationRate(6)
                        .inflationRateId(2)
                        .createdBy("Aman")
                        .modifiedBy("Aman")
                        .active(true)
                        .build());
        // Set up the expected response
        List<InflationRateResponse> expectedResponseList = List.of(InflationRateResponse.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .inflationRateId(1)
                .build(),
        InflationRateResponse.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .inflationRateId(1)
                .build());
        when(inflationRateRepository.findAll()).thenReturn(expectedEntityList);
        when(inflationRateEntityMapper.mapToInflationRateResponse(expectedEntityList)).thenReturn(expectedResponseList);

        List<InflationRateResponse> responseList = inflationRateService.getInflationRates();
        // Assert the response object
        Assertions.assertEquals(responseList.size(),expectedResponseList.size());
        Assertions.assertEquals(responseList.get(0).getInflationRate(), expectedResponseList.get(0).getInflationRate());
        Assertions.assertEquals(responseList.get(0).getInflationRateId(),expectedResponseList.get(0).getInflationRateId());
        Assertions.assertEquals(responseList.get(0).getActive(),expectedResponseList.get(0).getActive());
        Assertions.assertEquals(responseList.get(0).getCreatedBy(),expectedResponseList.get(0).getCreatedBy());
        Assertions.assertEquals(responseList.get(0).getModifiedBy(),expectedResponseList.get(0).getModifiedBy());

        Assertions.assertEquals(responseList.get(1).getInflationRate(), expectedResponseList.get(1).getInflationRate());
        Assertions.assertEquals(responseList.get(1).getInflationRateId(),expectedResponseList.get(1).getInflationRateId());
        Assertions.assertEquals(responseList.get(1).getActive(),expectedResponseList.get(1).getActive());
        Assertions.assertEquals(responseList.get(1).getCreatedBy(),expectedResponseList.get(1).getCreatedBy());
        Assertions.assertEquals(responseList.get(1).getModifiedBy(),expectedResponseList.get(1).getModifiedBy());
    }
}
