package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.dto.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddInflationRate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InflationRateEntityMapperTest {
    @Autowired
    private InflationRateEntityMapper inflationRateEntityMapper;

    @Test
    public void testMapToInflationRateResponseList(){
        InflationRate inflationRate1 = new InflationRate();
        inflationRate1.setInflationRate(4);
        inflationRate1.setCreatedBy("Sagar");
        inflationRate1.setModifiedBy("Sagar");
        inflationRate1.setActive(true);

        InflationRate inflationRate2 = new InflationRate();
        inflationRate2.setInflationRate(6);
        inflationRate2.setCreatedBy("Aman");
        inflationRate2.setModifiedBy("Aman");
        inflationRate2.setActive(true);

        List<InflationRate> entityList = List.of(inflationRate1,inflationRate2);

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
        InflationRate entity = new InflationRate();
        entity.setInflationRate(4);
        entity.setCreatedBy("Sagar");
        entity.setModifiedBy("Sagar");
        entity.setActive(true);

        InflationRateResponse response = inflationRateEntityMapper.mapToInflationRateResponse(entity);
        Assertions.assertEquals(entity.getInflationRate(),response.getInflationRate());
        Assertions.assertEquals(entity.getCreatedBy(),response.getCreatedBy());
        Assertions.assertEquals(entity.getModifiedBy(),response.getModifiedBy());
        Assertions.assertEquals(entity.isActive(),response.getActive());
    }

    @Test
    public void testMapToInflationRateEntity(){

        RequestToAddInflationRate request = new RequestToAddInflationRate();
        request.setInflationRate(4);
        request.setCreatedBy("Sagar");
        request.setModifiedBy("Sagar");
        InflationRate inflationRate = inflationRateEntityMapper.mapToInflationRateEntity(request);
        Assertions.assertEquals(request.getInflationRate(),inflationRate.getInflationRate());
        Assertions.assertEquals(request.getCreatedBy(),inflationRate.getCreatedBy());
        Assertions.assertEquals(request.getModifiedBy(),inflationRate.getModifiedBy());
    }
}

