/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.rest;

import com.adityabirlacapital.childlifeinsurance.dto.ResponseHandler;
import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import com.adityabirlacapital.childlifeinsurance.service.InflationRateService;
import com.adityabirlacapital.childlifeinsurance.dto.InflationRateResponse;
import com.adityabirlacapital.childlifeinsurance.dto.RequestToAddInflationRate;
import jakarta.validation.Valid;
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
	public ResponseEntity<Object> getInflationRate() {
		List<InflationRate> list = inflationRateService.getInflationRates();
		return new ResponseHandler().generateSuccessResponse(list,HttpStatus.OK,"Success");
	}

	@PostMapping
	public ResponseEntity<Object> addInflationRate(@Valid @RequestBody RequestToAddInflationRate request) {
		InflationRate response = inflationRateService.addInflationRates(request);
		return new ResponseHandler().generateSuccessResponse(response,HttpStatus.CREATED,"Saved Successfully");
	}
}
