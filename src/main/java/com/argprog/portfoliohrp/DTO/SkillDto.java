
package com.argprog.portfoliohrp.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */
@Getter @Setter
public class SkillDto {
    private String imgSkill;
    @NotBlank
    private String colorIn;
    @NotBlank
    private String colorOut;
    @NotBlank
    private String nameSkill;
    @NotBlank
    private int progress;

    public SkillDto(String imgSkill, String colorIn, String colorOut, String nameSkill, int progress) {
        this.imgSkill = imgSkill;
        this.colorIn = colorIn;
        this.colorOut = colorOut;
        this.nameSkill = nameSkill;
        this.progress = progress;
    }
}
