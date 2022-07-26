
package com.argprog.portfoliohrp.Security.Controller;

import com.argprog.portfoliohrp.Security.DTO.JwtDto;
import com.argprog.portfoliohrp.Security.DTO.LoginUser;
import com.argprog.portfoliohrp.Security.DTO.NewUser;
import com.argprog.portfoliohrp.Security.Entity.Rol;
import com.argprog.portfoliohrp.Security.Entity.User;
import com.argprog.portfoliohrp.Security.Enums.RolName;
import com.argprog.portfoliohrp.Security.JWT.JwtProvider;
import com.argprog.portfoliohrp.Security.Service.ImpRolService;
import com.argprog.portfoliohrp.Security.Service.ImpUserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author perey r
 *@contact pereyrahugor@gmail.com
 */

@RestController
@RequestMapping ("/auth")
@CrossOrigin 
public class AuthenticationController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ImpUserService impUserService;
    @Autowired
    ImpRolService ImpRolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping ("/newUser")
    public ResponseEntity<?> newUser (@Valid @RequestBody NewUser newUser, BindingResult bindingResult){ 
       if(bindingResult.hasErrors())
           return new ResponseEntity(new Mensaje("Campos o Correo Invalidos"),HttpStatus.BAD_REQUEST);
    
       if(impUserService.existsByUserName(newUser.getUserName()))
           return new ResponseEntity(new Mensaje("Nombre de Usuario ya utilizado"), HttpStatus.BAD_REQUEST);
    
        if(impUserService.existsByEmail(newUser.getEmail()))
           return new ResponseEntity(new Mensaje("Correo ya utilizado"), HttpStatus.BAD_REQUEST);
    
        User user = new User(newUser.getName(), newUser.getUserName(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
    
        Set<Rol> roles = new HashSet<>();
        roles.add(ImpRolService.getByRolName(RolName.ROLE_USER).get());
    
        if(newUser.getRoles().contains("admin"))
            roles.add(ImpRolService.getByRolName(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        impUserService.save(user);
        
        return new ResponseEntity (new Mensaje("Usuario Generado con Exito"), HttpStatus.CREATED);
        
    }
    
    @PostMapping ("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Usuario o Contraseña Incorrecto"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                            loginUser.getUserName(), loginUser.getPassword()));
   
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
    
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}
