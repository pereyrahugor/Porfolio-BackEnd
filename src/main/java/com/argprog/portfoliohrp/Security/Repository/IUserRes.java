
package com.argprog.portfoliohrp.Security.Repository;

import com.argprog.portfoliohrp.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pereyra.hugo.r
 */

@Repository
public interface IUserRes extends JpaRepository<User, Long>{
    Optional<User> findByUserName (String userName);
    
    boolean existsByUserName (String userName);
    boolean existsByEmail (String email);
}
