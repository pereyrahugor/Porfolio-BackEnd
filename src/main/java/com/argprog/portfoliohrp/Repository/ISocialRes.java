
package com.argprog.portfoliohrp.Repository;

import com.argprog.portfoliohrp.Entity.Social;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Repository
public interface ISocialRes extends JpaRepository <Social, Long> {
    public Optional<Social> findByNameSocial (String nameSocial);
    
    public boolean existsByNameSocial(String nameSocial);  
}
