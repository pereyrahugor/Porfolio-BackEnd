
package com.argprog.portfoliohrp.Security.Controller;

import lombok.Getter;
import lombok.Setter;

/**
 *@author perey r
 *@contact pereyrahugor@gmail.com
 */
@Getter @Setter
public class Mensaje {
    private String mensaje;
    
    public Mensaje(){
    }
    
    public Mensaje(String mensaje){
        this.mensaje = mensaje;
    }
}
