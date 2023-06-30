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
import java.util.ArrayList;
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
        RequestToAddInflationRate request = new RequestToAddInflationRate();
        request.setInflationRate(4);
        request.setCreatedBy("Sagar");
        request.setModifiedBy("Sagar");
        // Set up the requested entity
        InflationRate requestedEntity = new InflationRate();
        requestedEntity.setInflationRate(4);
        requestedEntity.setCreatedBy("Sagar");
        requestedEntity.setModifiedBy("Sagar");
        requestedEntity.setActive(true);
        requestedEntity.setInflationRateId(1);

        // Set up the expected entity
        InflationRate expectedEntity = new InflationRate();
        expectedEntity.setInflationRate(4);
        expectedEntity.setCreatedBy("Sagar");
        expectedEntity.setModifiedBy("Sagar");
        expectedEntity.setActive(true);
        expectedEntity.setInflationRateId(1);
        // Set up the expected response
        InflationRateResponse expectedResponse = new InflationRateResponse();
        expectedResponse.setInflationRate(4);
        expectedResponse.setCreatedBy("Sagar");
        expectedResponse.setModifiedBy("Sagar");
        expectedResponse.setActive(true);
        expectedResponse.setInflationRateId(1);

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
        InflationRate inflationRate1 = new InflationRate();
        inflationRate1.setInflationRate(4);
        inflationRate1.setInflationRateId(1);
        inflationRate1.setCreatedBy("Sagar");
        inflationRate1.setModifiedBy("Sagar");
        inflationRate1.setActive(true);

        InflationRate inflationRate2 = new InflationRate();
        inflationRate2.setInflationRate(6);
        inflationRate2.setInflationRateId(2);
        inflationRate2.setCreatedBy("Aman");
        inflationRate2.setModifiedBy("Aman");
        inflationRate2.setActive(true);
        List<InflationRate> expectedEntityList = List.of(inflationRate1,inflationRate2);
        // Set up the expected response

        InflationRateResponse inflationRateResponse1 = new InflationRateResponse();
        inflationRateResponse1.setInflationRate(4);
        inflationRateResponse1.setCreatedBy("Sagar");
        inflationRateResponse1.setModifiedBy("Sagar");
        inflationRateResponse1.setActive(true);
        inflationRateResponse1.setInflationRateId(1);

        InflationRateResponse inflationRateResponse2 = new InflationRateResponse();
        inflationRateResponse2.setInflationRate(6);
        inflationRateResponse2.setCreatedBy("Sagar");
        inflationRateResponse2.setModifiedBy("Sagar");
        inflationRateResponse2.setActive(true);
        inflationRateResponse2.setInflationRateId(2);
        List<InflationRateResponse> expectedResponseList = List.of(inflationRateResponse1,inflationRateResponse2);
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
