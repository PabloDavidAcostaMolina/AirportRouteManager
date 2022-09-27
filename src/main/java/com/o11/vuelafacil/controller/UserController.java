/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.controller;

import com.o11.vuelafacil.models.User;
import com.o11.vuelafacil.services.UserService;
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
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/")
    public ResponseEntity<User> agregar(@RequestBody User user){
        
        User obj = userService.save(user);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> eliminar(@PathVariable Integer id){
        User obj = userService.findById(id);
        if(obj != null)
            userService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<User> editar(@RequestBody User user){
        User obj = userService.findById(user.getIdUser());
        if(obj != null){
            obj.setUserName(user.getUserName());
            obj.setUserType(user.getUserType());
            userService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<User> consultarTodo(){
        return userService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public User consultarPorId(@PathVariable Integer id){
        return userService.findById(id);
    }
}
