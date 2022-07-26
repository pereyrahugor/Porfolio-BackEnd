
package com.argprog.portfoliohrp.Repository;

import com.argprog.portfoliohrp.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Repository
public interface IExperienceRes extends JpaRepository <Experience, Long> {
    public Optional<Experience> findByPosition (String position);
    
    public boolean existsByPosition(String position);
}
