
package com.argprog.portfoliohrp.Controller;


import com.argprog.portfoliohrp.DTO.ProjectDto;
import com.argprog.portfoliohrp.Entity.Project;
import com.argprog.portfoliohrp.Security.Controller.Mensaje;
import com.argprog.portfoliohrp.Service.ImpProjectService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @contact pereyrahugor@gmail.com
 * @author pereyra.hugo.r
 */

@RestController
@RequestMapping ("/Proyecto")
@CrossOrigin ("https://porfolio-frontend-argprog-hrp.web.app/")
public class ProjectController {
    @Autowired
    ImpProjectService impProjectService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Project>> list(){
        List<Project> list = impProjectService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") long id){
        if(!impProjectService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
        Project project = impProjectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    
    @PostMapping ("/save")
    public ResponseEntity<?> create(@RequestBody ProjectDto projectDto){
        if(StringUtils.isBlank(projectDto.getNameProject()))
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impProjectService.existsByNameProject(projectDto.getNameProject()))
            return new ResponseEntity(new Mensaje("El proyecto ingresado ya existe"), HttpStatus.BAD_REQUEST);
        Project project = new Project(projectDto.getImgProject(), projectDto.getNameProject(),
                                      projectDto.getDescriptionProject(), projectDto.getLinkProject());
        impProjectService.save(project);
        return new ResponseEntity(new Mensaje("Nueva Proyecto Agregado Correctamente"), HttpStatus.OK);
        
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody ProjectDto projectDto){
        if(!impProjectService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(impProjectService.existsByNameProject(projectDto.getNameProject())
            && 
           impProjectService.getByNameProject(projectDto.getNameProject()).get().getId() !=id)
                return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getNameProject()))
            return new ResponseEntity(new Mensaje("El Nombre del Proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        Project project = impProjectService.getOne(id).get();
        project.setNameProject(projectDto.getNameProject());
        project.setDescriptionProject(projectDto.getDescriptionProject());
        project.setImgProject(projectDto.getImgProject());
        project.setLinkProject(projectDto.getLinkProject());
            impProjectService.save(project);
            return new ResponseEntity(new Mensaje("Proyecto Actualizado Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!impProjectService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        impProjectService.delete(id);
            return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
}
