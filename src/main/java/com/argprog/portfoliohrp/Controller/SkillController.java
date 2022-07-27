
package com.argprog.portfoliohrp.Controller;

import com.argprog.portfoliohrp.DTO.SkillDto;
import com.argprog.portfoliohrp.Entity.Skill;
import com.argprog.portfoliohrp.Security.Controller.Mensaje;
import com.argprog.portfoliohrp.Service.ImpSkillService;
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
@RequestMapping ("/Habilidad")
@CrossOrigin ("https://porfolio-frontend-argprog-hrp.web.app")
public class SkillController {
    @Autowired
    ImpSkillService impSkillService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Skill>> list(){
        List<Skill> list = impSkillService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") long id){
        if(!impSkillService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
        Skill skill = impSkillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping ("/save")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto){
        if(StringUtils.isBlank(skillDto.getNameSkill()))
            return new ResponseEntity(new Mensaje("El nombre de la Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impSkillService.existsByNameSkill(skillDto.getNameSkill()))
            return new ResponseEntity(new Mensaje("La Habilidad ingresada ya existe"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(skillDto.getImgSkill(), skillDto.getColorIn(), skillDto.getColorOut(),
                                      skillDto.getNameSkill(), skillDto.getProgress());
        impSkillService.save(skill);
        return new ResponseEntity(new Mensaje("Nueva Habilidad Agregada Correctamente"), HttpStatus.OK);
        
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody SkillDto skillDto){
        if(!impSkillService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(impSkillService.existsByNameSkill(skillDto.getNameSkill())
            && 
           impSkillService.getByNameSkill(skillDto.getNameSkill()).get().getId() !=id)
                return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getNameSkill()))
            return new ResponseEntity(new Mensaje("El Nombre de la Habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        Skill skill = impSkillService.getOne(id).get();
        skill.setNameSkill(skillDto.getNameSkill());
        skill.setImgSkill(skillDto.getImgSkill());
        skill.setColorOut(skillDto.getColorOut());
        skill.setColorIn(skillDto.getColorIn());
        skill.setProgress(skillDto.getProgress());
            impSkillService.save(skill);
            return new ResponseEntity(new Mensaje("Habilidad Actualizada Correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!impSkillService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        impSkillService.delete(id);
            return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
    }
}
