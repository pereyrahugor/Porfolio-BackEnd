package com.argprog.portfoliohrp.Entity;
import java.util.Date;
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
public class Experience{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    /*private long idPersona;*/
    private String imgBusiness;
    private String business;
    private String position;
    private Date yearIn;
    private Date yearOut;
    private String descriptionPosition;

    public Experience() {
    }

    public Experience(String imgBusiness, String business, String position,
                      Date yearIn, Date yearOut, String descriptionPosition) {
        this.imgBusiness = imgBusiness;
        this.business = business;
        this.position = position;
        this.yearIn = yearIn;
        this.yearOut = yearOut;
        this.descriptionPosition = descriptionPosition;
    }
      
}