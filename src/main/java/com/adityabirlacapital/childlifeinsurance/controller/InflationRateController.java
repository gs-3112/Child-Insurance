/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.controller;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.service.InflationRateService;
import com.adityabirlacapital.childlifeinsurance.vo.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.vo.RequestToAddInflationRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoint controller for inflation rate
 */
@RestController
@RequestMapping("oneappabc/adityabirla/api/v1/inflationrate")
public class InflationRateController {
	@Autowired
	private InflationRateService inflationRateService;
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<InflationRateResponse> getInflationRate() {
		List<InflationRateResponse> list = inflationRateService.getInflationRates();
		return list;
	}

	@PostMapping
	public ResponseEntity<InflationRateResponse> addInflationRate(@RequestBody RequestToAddInflationRate request) {
		InflationRateResponse response = inflationRateService.addInflationRates(request);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
}
