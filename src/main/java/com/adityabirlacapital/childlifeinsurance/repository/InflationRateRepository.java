/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.repository;

import com.adityabirlacapital.childlifeinsurance.entity.InflationRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface InflationRateRepository extends JpaRepository<InflationRate,Integer>{

	
}
