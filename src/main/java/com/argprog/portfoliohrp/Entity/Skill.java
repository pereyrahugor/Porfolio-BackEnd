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
public class Skill{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
   /* private Long idPersona;*/
    private String imgSkill;
    private String colorIn;
    private String colorOut;
    private String nameSkill;
    private int progress;

    public Skill() {
    }

    public Skill(String imgSkill, String colorIn, String colorOut, String nameSkill, int progress) {
        this.imgSkill = imgSkill;
        this.colorIn = colorIn;
        this.colorOut = colorOut;
        this.nameSkill = nameSkill;
        this.progress = progress;
    }
          
}