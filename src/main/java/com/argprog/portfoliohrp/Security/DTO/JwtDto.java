
package com.argprog.portfoliohrp.Security.DTO;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 *@author perey r
 *@contact pereyrahugor@gmail.com
 */

@Getter @Setter
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String userName, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.userName = userName;
        this.authorities = authorities;
    }
    
    
    
}
