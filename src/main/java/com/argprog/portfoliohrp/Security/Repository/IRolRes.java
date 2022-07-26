
package com.argprog.portfoliohrp.Security.Repository;

import com.argprog.portfoliohrp.Security.Entity.Rol;
import com.argprog.portfoliohrp.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pereyra.hugo.r
 */

@Repository
public interface IRolRes extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolName (RolName rolName);
}
