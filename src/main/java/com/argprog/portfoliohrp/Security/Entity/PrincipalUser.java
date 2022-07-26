
package com.argprog.portfoliohrp.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author pereyra.hugo.r
 */
public class PrincipalUser implements UserDetails{
    private String name;
    private String userName;
    private String email;
    private String password;
    private Collection <? extends GrantedAuthority> autorities;

    public PrincipalUser(String name, String userName, String email, String password, Collection<? extends GrantedAuthority> autorities) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.autorities = autorities;
    }
        
    public static PrincipalUser build (User user){
        List<GrantedAuthority> autorities = 
                user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());
        return new PrincipalUser (user.getName(), user.getUserName(), user.getEmail(), user.getPassword(), autorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorities;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}
