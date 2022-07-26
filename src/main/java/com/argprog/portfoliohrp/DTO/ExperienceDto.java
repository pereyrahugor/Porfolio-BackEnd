
package com.argprog.portfoliohrp.DTO;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */
@Getter @Setter
public class ExperienceDto {
    private String imgBusiness;
    @NotBlank
    private String business;
    @NotBlank
    private String position;
    @NotBlank
    private Date yearIn;
    private Date yearOut;
    @NotBlank
    private String descriptionPosition;

    public ExperienceDto(String imgBusiness, String business, String position,
                         Date yearIn, Date yearOut, String descriptionPosition) {
        this.imgBusiness = imgBusiness;
        this.business = business;
        this.position = position;
        this.yearIn = yearIn;
        this.yearOut = yearOut;
        this.descriptionPosition = descriptionPosition;
    }
    
    
        
}
