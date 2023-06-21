/**
 *
 */
package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.vo.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToAddInflationRate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Component
public class InflationRateEntityMapper {

    public List<InflationRateResponse> mapToInflationRateResponse(List<InflationRate> findAll) {
        List<InflationRateResponse> list = new ArrayList<InflationRateResponse>();
        for (InflationRate inflationRate : findAll) {
            InflationRateResponse response = new InflationRateResponse();
            response.setInflationRate(inflationRate.getInflationRate());
            response.setInflationRateId(inflationRate.getInflationRateId());
            list.add(response);
        }
        return list;
    }

    public InflationRateResponse mapToInflationRateResponse(InflationRate inflationRate) {
        InflationRateResponse response = new InflationRateResponse();
        response.setInflationRate(inflationRate.getInflationRate());
        response.setInflationRateId(inflationRate.getInflationRateId());
        return response;
    }

    public InflationRate mapToInflationRateEntity(RequestToAddInflationRate request) {
        InflationRate entity = new InflationRate();
        entity.setInflationRate(request.getInflationRate());
		entity.setActive(true);
		entity.setCreatedBy(request.getCreatedBy());
		entity.setModifiedBy(request.getModifiedBy());
		entity.setCreatedDate(LocalDateTime.now());
        entity.setModifiedDate(LocalDateTime.now());
        return entity;
    }
}
