/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.service;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.mapper.InflationRateEntityMapper;
import com.adityabirlacapital.childlifeinsurance.repository.InflationRateRepository;
import com.adityabirlacapital.childlifeinsurance.dto.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddInflationRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 
 */
@Service
public class InflationRateService {
	
	@Autowired
	private InflationRateRepository inflationRateRepository;
	@Autowired
	private InflationRateEntityMapper mapper;
	
	public List<InflationRate> getInflationRates() {
//		List<InflationRateResponse> list =  mapper.mapToInflationRateResponse(inflationRateRepository.findAll());
		return inflationRateRepository.findAll();
	}

	public InflationRate addInflationRates(RequestToAddInflationRate request) {
		InflationRate entity = mapper.mapToInflationRateEntity(request);
//		InflationRateResponse response = mapper.mapToInflationRateResponse(inflationRateRepository.save(entity));
		return inflationRateRepository.save(entity);
	}
}
