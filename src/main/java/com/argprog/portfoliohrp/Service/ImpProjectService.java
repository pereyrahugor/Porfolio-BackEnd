
package com.argprog.portfoliohrp.Service;

import com.argprog.portfoliohrp.Entity.Project;
import com.argprog.portfoliohrp.Repository.IProjectRes;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Service
@Transactional
public class ImpProjectService{
    @Autowired
    IProjectRes iprojectRes;
    
   public List<Project> list(){
        return iprojectRes.findAll();
    }
    
    public Optional<Project> getOne(long id){
        return iprojectRes.findById(id);
    }
    
    public Optional<Project> getByNameProject (String nameProject){
        return iprojectRes.findByNameProject(nameProject);
    }
    
    public void save(Project project){
        iprojectRes.save(project);
    }
    
    public void delete(long id){
        iprojectRes.deleteById(id);
    }
    
    public boolean existById(long id){
        return iprojectRes.existsById(id);
    }
    
    public boolean existsByNameProject(String nameProject){
        return iprojectRes.existsByNameProject(nameProject);
                
    }
    
}
