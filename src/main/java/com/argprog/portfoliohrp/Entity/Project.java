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
public class Project{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    /*private long idPersona;*/
    private String imgProject;
    private String nameProject;
    private String descriptionProject;
    private String linkProject;

    public Project() {
    }

    public Project(String imgProject, String nameProject, String descriptionProject, String linkProject) {
        this.imgProject = imgProject;
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.linkProject = linkProject;
    }
         
}