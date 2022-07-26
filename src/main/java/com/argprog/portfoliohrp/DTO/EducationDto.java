
package com.argprog.portfoliohrp.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */
@Getter @Setter
public class EducationDto {
    private String imgInstitute;
    @NotBlank
    private String title;
    @NotBlank
    private String yearStudied;
    @NotBlank
    private String duration;
    @NotBlank
    private String descriptionEducation;

    public EducationDto(String imgInstitute, String title,
                     String yearStudied, String duration, String descriptionEducation) {
        this.imgInstitute = imgInstitute;
        this.title = title;
        this.yearStudied = yearStudied;
        this.duration = duration;
        this.descriptionEducation = descriptionEducation;
    }
}
