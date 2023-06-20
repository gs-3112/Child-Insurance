/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adityabirlacapital.childlifeinsurance.controller.entity.ChildPlan;

/**
 * 
 */
@Repository
public interface ChildPlanRepositoy extends JpaRepository<ChildPlan, Integer>{

}
