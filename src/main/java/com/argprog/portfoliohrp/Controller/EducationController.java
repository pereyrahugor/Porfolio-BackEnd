
package com.argprog.portfoliohrp.Controller;

import com.argprog.portfoliohrp.DTO.EducationDto;
import com.argprog.portfoliohrp.Entity.Education;
import com.argprog.portfoliohrp.Security.Controller.Mensaje;
import com.argprog.portfoliohrp.Service.ImpEducationService;
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
@RequestMapping ("/Educacion")
@CrossOrigin (origins = "https://porfolio-frontend-argprog-hrp.web.app/")
public class EducationController {
    @Autowired
    ImpEducationService impEducationService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Education>> list(){
        List<Education> list = impEducationService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") long id){
        if(!impEducationService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
        Education education = impEducationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @PostMapping ("/save")
    public ResponseEntity<?> create(@RequestBody EducationDto educationDto){
        if(StringUtils.isBlank(educationDto.getTitle()))
            return new ResponseEntity(new Mensaje("El Estudio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impEducationService.existsByTitle(educationDto.getTitle()))
            return new ResponseEntity(new Mensaje("El Titulo ingresado ya existe"), HttpStatus.BAD_REQUEST);
        Education education = new Education(educationDto.getImgInstitute(), educationDto.getTitle(), educationDto.getYearStudied(),
                                            educationDto.getDuration(), educationDto.getDescriptionEducation());
        impEducationService.save(education);
        return new ResponseEntity(new Mensaje("Nueva Educación Agregada Correctamente"), HttpStatus.OK);
        
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody EducationDto educationDto){
        if(!impEducationService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(impEducationService.existsByTitle(educationDto.getTitle())
            && 
           impEducationService.getByTitle(educationDto.getTitle()).get().getId() !=id)
                return new ResponseEntity(new Mensaje("Esa Educación ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getTitle()))
            return new ResponseEntity(new Mensaje("El puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        Education education = impEducationService.getOne(id).get();
        education.setImgInstitute(educationDto.getImgInstitute());
        education.setTitle(educationDto.getTitle());
        education.setYearStudied(educationDto.getYearStudied());
        education.setDuration(educationDto.getDuration());
        education.setDescriptionEducation(educationDto.getDescriptionEducation());
            impEducationService.save(education);
            return new ResponseEntity(new Mensaje("Educación Actualizada Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!impEducationService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        impEducationService.delete(id);
            return new ResponseEntity(new Mensaje("Educación Eliminada"), HttpStatus.OK);
    }
    
}
