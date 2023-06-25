package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.vo.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToAddInflationRate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class InflationRateEntityMapperTest {
    @Autowired
    private InflationRateEntityMapper inflationRateEntityMapper;


    @Test
    public void testMapToInflationRateResponseList(){
        List<InflationRate> entityList = List.of(InflationRate.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .build(),
        InflationRate.builder()
                .inflationRate(6)
                .createdBy("Aman")
                .modifiedBy("Aman")
                .active(true)
                .build());
        List<InflationRateResponse> responseList = inflationRateEntityMapper.mapToInflationRateResponse(entityList);
        Assertions.assertEquals(responseList.size(),entityList.size());
        Assertions.assertEquals(entityList.get(0).getInflationRate(),responseList.get(0).getInflationRate());
        Assertions.assertEquals(entityList.get(0).getCreatedBy(),responseList.get(0).getCreatedBy());
        Assertions.assertEquals(entityList.get(0).getModifiedBy(),responseList.get(0).getModifiedBy());
        Assertions.assertEquals(entityList.get(0).isActive(),responseList.get(0).getActive());
        Assertions.assertEquals(entityList.get(1).getInflationRate(),responseList.get(1).getInflationRate());
        Assertions.assertEquals(entityList.get(1).getCreatedBy(),responseList.get(1).getCreatedBy());
        Assertions.assertEquals(entityList.get(1).getModifiedBy(),responseList.get(1).getModifiedBy());
        Assertions.assertEquals(entityList.get(1).isActive(),responseList.get(1).getActive());

    }
    @Test
    public void testMapToInflationRateResponse(){
        InflationRate entity = InflationRate.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .build();
        InflationRateResponse response = inflationRateEntityMapper.mapToInflationRateResponse(entity);
        Assertions.assertEquals(entity.getInflationRate(),response.getInflationRate());
        Assertions.assertEquals(entity.getCreatedBy(),response.getCreatedBy());
        Assertions.assertEquals(entity.getModifiedBy(),response.getModifiedBy());
        Assertions.assertEquals(entity.isActive(),response.getActive());
    }

    @Test
    public void testMapToInflationRateEntity(){
        RequestToAddInflationRate request = RequestToAddInflationRate.builder()
                .inflationRate(4)
                .createdBy("Sagar")
                .modifiedBy("Sagar")
                .active(true)
                .build();
        InflationRate inflationRate = inflationRateEntityMapper.mapToInflationRateEntity(request);
        Assertions.assertEquals(request.getInflationRate(),inflationRate.getInflationRate());
        Assertions.assertEquals(request.getCreatedBy(),inflationRate.getCreatedBy());
        Assertions.assertEquals(request.getModifiedBy(),inflationRate.getModifiedBy());
        Assertions.assertEquals(request.isActive(),inflationRate.isActive());
    }
}

