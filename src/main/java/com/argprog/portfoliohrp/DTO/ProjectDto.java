
package com.argprog.portfoliohrp.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */
@Getter @Setter
public class ProjectDto {
    private String imgProject;   
    @NotBlank
    private String nameProject; 
    @NotBlank
    private String descriptionProject; 
    @NotBlank
    private String linkProject;

    public ProjectDto(String imgProject, String nameProject, String descriptionProject, String linkProject) {
        this.imgProject = imgProject;
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.linkProject = linkProject;
    }
}
