package com.devopsbuddy.backend.persistence.repositories;

import com.devopsbuddy.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jonathan on 11/3/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
