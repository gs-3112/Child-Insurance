/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.repository;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface ChildPlanRepositoy extends JpaRepository<ChildPlan, Integer>{

}
