/**
 *
 */
package com.adityabirlacapital.childlifeinsurance.mapper;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.dto.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddInflationRate;
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
            list.add(mapToInflationRateResponse(inflationRate));
        }
        return list;
    }

    public InflationRateResponse mapToInflationRateResponse(InflationRate inflationRate) {
        InflationRateResponse response = new InflationRateResponse();
        response.setInflationRateId(inflationRate.getInflationRateId());
        response.setInflationRate(inflationRate.getInflationRate());
        response.setActive(inflationRate.isActive());
        response.setModifiedBy(inflationRate.getModifiedBy());
        response.setCreatedBy(inflationRate.getCreatedBy());
        response.setCreatedDate(inflationRate.getCreatedDate());
        response.setModifiedDate(inflationRate.getModifiedDate());
        return response;
    }

    public InflationRate mapToInflationRateEntity(RequestToAddInflationRate request) {
        InflationRate entity = new InflationRate();
        entity.setInflationRate(request.getInflationRate());
        entity.setCreatedBy(request.getCreatedBy());
        entity.setModifiedBy(request.getModifiedBy());
        entity.setCreatedDate(LocalDateTime.now());
        entity.setModifiedDate(LocalDateTime.now());
        return entity;
    }
}
