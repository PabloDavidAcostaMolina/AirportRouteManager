/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.controller;

import com.o11.vuelafacil.models.Restriction;
import com.o11.vuelafacil.services.RestrictionService;
import java.util.List;
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
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/restriction")
public class RestrictionController {
    
    @Autowired
    private RestrictionService restrictionService;
    
    @PostMapping(value = "/")
    public ResponseEntity<Restriction> agregar(@RequestBody Restriction restriction){
        
        Restriction obj = restrictionService.save(restriction);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Restriction> eliminar(@PathVariable Integer id){
        Restriction obj = restrictionService.findById(id);
        if(obj != null)
            restrictionService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Restriction> editar(@RequestBody Restriction restriction){
        Restriction obj = restrictionService.findById(restriction.getIdRestriction());
        if(obj != null){
            obj.setRestrictionDesc(restriction.getRestrictionDesc());
            restrictionService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Restriction> consultarTodo(){
        return restrictionService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Restriction consultarPorId(@PathVariable Integer id){
        return restrictionService.findById(id);
    }
}
