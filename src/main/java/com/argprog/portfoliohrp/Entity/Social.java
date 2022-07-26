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
public class Social{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    /*private Long idPersona;*/
    private String imgSocial;
    private String nameSocial;
    private String linkSocial;

    public Social() {
    }

    public Social(String imgSocial, String nameSocial, String linkSocial) {
        this.imgSocial = imgSocial;
        this.nameSocial = nameSocial;
        this.linkSocial = linkSocial;
    }
        
}