package com.argprog.portfoliohrp.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@Entity
@Setter @Getter
public class Persona{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String text;
    private String lastName;
    private String description;
    private String imgPerfil;
    private String imgBanner;
    private String country;
    private String estate;
    private String contact;
    private String phone;

    public Persona() {
    }

    public Persona(String name, String text, String lastName, String description,
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