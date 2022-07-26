
package com.argprog.portfoliohrp.Security.Service;

import com.argprog.portfoliohrp.Security.Entity.Rol;
import com.argprog.portfoliohrp.Security.Enums.RolName;
import com.argprog.portfoliohrp.Security.Repository.IRolRes;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pereyra.hugo.r
 */

@Service
@Transactional
public class ImpRolService {
    @Autowired 
    IRolRes iRolRes;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return iRolRes.findByRolName(rolName);
    }
    
    public void save(Rol rol){
        iRolRes.save(rol);
    }
    
}
