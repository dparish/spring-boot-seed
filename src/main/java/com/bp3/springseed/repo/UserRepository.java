package com.bp3.springseed.repo;

import com.bp3.springseed.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dparish
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
