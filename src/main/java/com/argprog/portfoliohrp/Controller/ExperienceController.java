
package com.argprog.portfoliohrp.Controller;

import com.argprog.portfoliohrp.DTO.ExperienceDto;
import com.argprog.portfoliohrp.Entity.Experience;
import com.argprog.portfoliohrp.Security.Controller.Mensaje;
import com.argprog.portfoliohrp.Service.ImpExperienceService;
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
@RequestMapping ("/Experiencia")
@CrossOrigin (origins = "https://porfolio-frontend-argprog-hrp.web.app/")
public class ExperienceController {
    @Autowired
    ImpExperienceService impExperienceService;
    
    @GetMapping ("/list")
    public  ResponseEntity <List<Experience>> list(){
        List<Experience> list = impExperienceService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") long id){
        if(!impExperienceService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
        Experience experiencia = impExperienceService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping ("/save")
    public ResponseEntity<?> create(@RequestBody ExperienceDto experienceDto){
        if(StringUtils.isBlank(experienceDto.getBusiness()))
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impExperienceService.existsByPosition(experienceDto.getPosition()))
            return new ResponseEntity(new Mensaje("El puesto ingresado ya existe"), HttpStatus.BAD_REQUEST);
        Experience experience = new Experience(experienceDto.getImgBusiness(), experienceDto.getBusiness(), experienceDto.getPosition(),
                                               experienceDto.getYearIn(), experienceDto.getYearOut(), experienceDto.getDescriptionPosition());
        impExperienceService.save(experience);
        return new ResponseEntity(new Mensaje("Nueva Experiencia Agregada Correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody ExperienceDto experienceDto){
        if(!impExperienceService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(impExperienceService.existsByPosition(experienceDto.getPosition())
            && 
           impExperienceService.getByPosition(experienceDto.getPosition()).get().getId() !=id)
                return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getPosition()))
            return new ResponseEntity(new Mensaje("El puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        Experience experience = impExperienceService.getOne(id).get();
        experience.setImgBusiness(experienceDto.getImgBusiness());
        experience.setBusiness(experienceDto.getBusiness());
        experience.setPosition(experienceDto.getPosition());
        experience.setYearIn(experienceDto.getYearIn());
        experience.setYearOut(experienceDto.getYearOut());
        experience.setDescriptionPosition(experienceDto.getDescriptionPosition());
            impExperienceService.save(experience);
            return new ResponseEntity(new Mensaje("Experiencia Actualizada Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!impExperienceService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        impExperienceService.delete(id);
            return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
    
}
