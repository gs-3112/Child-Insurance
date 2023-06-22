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
            InflationRateResponse response = InflationRateResponse.builder()
                    .inflationRateId(inflationRate.getInflationRateId())
                    .inflationRate(inflationRate.getInflationRate())
                    .build();
            list.add(response);
        }
        return list;
    }

    public InflationRateResponse mapToInflationRateResponse(InflationRate inflationRate) {
        InflationRateResponse response = InflationRateResponse.builder()
                .inflationRateId(inflationRate.getInflationRateId())
                .inflationRate(inflationRate.getInflationRate())
                .build();
        return response;
    }

    public InflationRate mapToInflationRateEntity(RequestToAddInflationRate request) {
        InflationRate entity = InflationRate.builder()
                .inflationRate(request.getInflationRate())
                .active(request.isActive())
                .createdBy(request.getCreatedBy())
                .modifiedBy(request.getModifiedBy())
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();
        return entity;
    }
}
