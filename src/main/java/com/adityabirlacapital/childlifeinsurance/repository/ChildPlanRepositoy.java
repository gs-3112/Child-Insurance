/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.repository;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import com.adityabirlacapital.childlifeinsurance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface ChildPlanRepositoy extends JpaRepository<ChildPlan, Integer>{

    List<ChildPlan> findByCustomerId(Long customerId);
}
