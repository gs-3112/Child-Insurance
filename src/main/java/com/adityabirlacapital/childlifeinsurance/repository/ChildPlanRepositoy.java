/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.repository;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * 
 */
@Repository
public interface ChildPlanRepositoy extends JpaRepository<ChildPlan, Long>{

    List<ChildPlan> findByCustomerId(Long customerId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ChildPlan c SET c.isInterestedInPlan =:isInterestedInPlan WHERE c.liChildId =:childPlanId")
    Integer updateIfInterestedInPlan(long childPlanId,Boolean isInterestedInPlan);
}

