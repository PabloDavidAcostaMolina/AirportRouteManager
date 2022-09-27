/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.controller;

import com.o11.vuelafacil.models.Status;
import com.o11.vuelafacil.services.StatusService;
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
@RequestMapping("/status")
public class StatusController {
    
    @Autowired
    private StatusService statusService;
    
    @PostMapping(value = "/")
    public ResponseEntity<Status> agregar(@RequestBody Status status){
        
        Status obj = statusService.save(status);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Status> eliminar(@PathVariable Integer id){
        Status obj = statusService.findById(id);
        if(obj != null)
            statusService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Status> editar(@RequestBody Status status){
        Status obj = statusService.findById(status.getIdStatus());
        if(obj != null){
            obj.setStatus(status.getStatus());
            obj.setRestriction(status.getRestriction());
            statusService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Status> consultarTodo(){
        return statusService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Status consultarPorId(@PathVariable Integer id){
        return statusService.findById(id);
    }
}
