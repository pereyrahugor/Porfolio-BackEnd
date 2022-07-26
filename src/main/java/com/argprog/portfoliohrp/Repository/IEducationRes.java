
package com.argprog.portfoliohrp.Repository;

import com.argprog.portfoliohrp.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Repository
public interface IEducationRes extends JpaRepository <Education, Long> {
    public Optional<Education> findByTitle (String title);
    
    public boolean existsByTitle(String title);
}
