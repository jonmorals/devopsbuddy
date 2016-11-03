package com.devopsbuddy.backend.persistence.repositories;

import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jonathan on 11/3/2016.
 */
@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer>{
}
