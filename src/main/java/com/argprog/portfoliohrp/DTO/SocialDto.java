
package com.argprog.portfoliohrp.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */
@Getter @Setter
public class SocialDto {
    private String imgSocial;
    @NotBlank
    private String nameSocial;
    @NotBlank
    private String linkSocial;

    public SocialDto(String imgSocial, String nameSocial, String linkSocial) {
        this.imgSocial = imgSocial;
        this.nameSocial = nameSocial;
        this.linkSocial = linkSocial;
    }
}
