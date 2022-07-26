
package com.argprog.portfoliohrp.Service;

import com.argprog.portfoliohrp.Entity.Project;
import com.argprog.portfoliohrp.Entity.Skill;
import com.argprog.portfoliohrp.Repository.ISkillRes;
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
public class ImpSkillService{
    @Autowired
    ISkillRes iskillRes;
    
   public List<Skill> list(){
        return iskillRes.findAll();
    }
    
    public Optional<Skill> getOne(long id){
        return iskillRes.findById(id);
    }
    
    public Optional<Skill> getByNameSkill (String nameSkill){
        return iskillRes.findByNameSkill(nameSkill);
    }
    
    public void save(Skill skill){
        iskillRes.save(skill);
    }
    
    public void delete(long id){
        iskillRes.deleteById(id);
    }
    
    public boolean existById(long id){
        return iskillRes.existsById(id);
    }
    
    public boolean existsByNameSkill(String nameSkill){
        return iskillRes.existsByNameSkill(nameSkill);
                
    }
    
}
