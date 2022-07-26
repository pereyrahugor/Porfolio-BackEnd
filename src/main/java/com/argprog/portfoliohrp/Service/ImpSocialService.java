
package com.argprog.portfoliohrp.Service;

import com.argprog.portfoliohrp.Entity.Social;
import com.argprog.portfoliohrp.Repository.ISocialRes;
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
public class ImpSocialService{
    @Autowired
    ISocialRes isocialRes;
    
    public List<Social> list(){
        return isocialRes.findAll();
    }
    
    public Optional<Social> getOne(long id){
        return isocialRes.findById(id);
    }
    
    public Optional<Social> getByNameSocial (String nameSocial){
        return isocialRes.findByNameSocial(nameSocial);
    }
    
    public void save(Social social){
        isocialRes.save(social);
    }
    
    public void delete(long id){
        isocialRes.deleteById(id);
    }
    
    public boolean existById(long id){
        return isocialRes.existsById(id);
    }
    
    public boolean existsByNameSocial(String nameSocial){
        return isocialRes.existsByNameSocial(nameSocial);
                
    }
    
}
