
package com.argprog.portfoliohrp.Security.Service;

import com.argprog.portfoliohrp.Security.Entity.PrincipalUser;
import com.argprog.portfoliohrp.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author pereyra.hugo.r
 */

@Service

public class ImpUserDetailsService implements UserDetailsService{
    @Autowired
    ImpUserService impUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = impUserService.getByUserName(userName).get();
        return PrincipalUser.build(user);
    }
    
    
}
