
package com.argprog.portfoliohrp.Repository;

import com.argprog.portfoliohrp.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Repository
public interface ISkillRes extends JpaRepository <Skill, Long> {
    public Optional<Skill> findByNameSkill (String nameSkill);
    
    public boolean existsByNameSkill(String nameSkill);  
}
