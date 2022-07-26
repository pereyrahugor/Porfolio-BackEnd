
package com.argprog.portfoliohrp.Service;

import com.argprog.portfoliohrp.Entity.Education;
import com.argprog.portfoliohrp.Repository.IEducationRes;
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
public class ImpEducationService{
    @Autowired
    IEducationRes ieducationRes;
    
    public List<Education> list(){
        return ieducationRes.findAll();
    }
    
    public Optional<Education> getOne(long id){
        return ieducationRes.findById(id);
    }
    
    public Optional<Education> getByTitle (String title){
        return ieducationRes.findByTitle(title);
    }
    
    public void save(Education education){
        ieducationRes.save(education);
    }
    
    public void delete(long id){
        ieducationRes.deleteById(id);
    }
    
    public boolean existById(long id){
        return ieducationRes.existsById(id);
    }
    
    public boolean existsByTitle(String title){
        return ieducationRes.existsByTitle(title);
                
    }

}