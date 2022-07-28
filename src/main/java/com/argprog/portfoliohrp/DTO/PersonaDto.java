
package com.argprog.portfoliohrp.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */
@Getter @Setter
public class PersonaDto {
    @NotBlank
    private String name;
    @NotBlank
    private String text;
    @NotBlank
    private String lastName;    
    @NotBlank
    private String description;    
    private String imgPerfil;    
    private String imgBanner;    
    @NotBlank
    private String country;        
    @NotBlank
    private String estate;            
    @NotBlank
    private String contact;
    @NotBlank
    private String phone;

    public PersonaDto(String name, String text, String lastName, String description,
                      String imgPerfil, String imgBanner, String country, String estate, String contact, String phone) {
        this.name = name;
        this.text = text;
        this.lastName = lastName;
        this.description = description;
        this.imgPerfil = imgPerfil;
        this.imgBanner = imgBanner;
        this.country = country;
        this.estate = estate;
        this.contact = contact;
        this.phone = phone;
    }
}
