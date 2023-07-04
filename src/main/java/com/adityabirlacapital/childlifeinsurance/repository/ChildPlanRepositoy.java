/**
 * 
 */
package com.adityabirlacapital.childlifeinsurance.repository;

import com.adityabirlacapital.childlifeinsurance.entity.ChildPlan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 */
@Repository
public interface ChildPlanRepositoy extends JpaRepository<ChildPlan, Long>{

    List<ChildPlan> findByCustomerId(Long customerId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ChildPlan c SET c.modifiedBy =:modifiedBy,c.modifiedDate =:modifiedDate,c.isInterestedInPlan =:isInterestedInPlan WHERE c.liChildId =:childPlanId")
    Integer updateIfInterestedInPlan(long childPlanId, Boolean isInterestedInPlan, String modifiedBy, LocalDateTime modifiedDate);

    @Query("SELECT cp FROM ChildPlan cp WHERE cp.customer.id =:customerId AND cp.childName =:childName AND cp.childAge =:childAge AND cp.goalType =:goalType AND cp.goalAmt =:goalAmt AND cp.goalTenure =:goalTenure AND cp.roi =:roi AND cp.tenure =:tenure AND cp.createdBy =:createdBy AND cp.modifiedBy =:modifiedBy")
    ChildPlan findByUniqueKey(Long customerId,String childName,Integer childAge,String goalType,Double goalAmt,
                              Double goalTenure,Double roi,Double tenure,String createdBy,String modifiedBy);
}

