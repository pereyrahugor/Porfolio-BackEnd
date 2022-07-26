
package com.argprog.portfoliohrp.Repository;

import com.argprog.portfoliohrp.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Repository
public interface IProjectRes extends JpaRepository <Project, Long> {
    public Optional<Project> findByNameProject (String nameProject);
    
    public boolean existsByNameProject(String nameProject);    
}
