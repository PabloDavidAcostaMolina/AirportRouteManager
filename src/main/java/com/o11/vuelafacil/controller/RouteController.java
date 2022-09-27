/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.controller;

import com.o11.vuelafacil.models.Route;
import com.o11.vuelafacil.services.RouteService;
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
@RequestMapping("/route")
public class RouteController {
    
    @Autowired
    private RouteService routeService;
    
    @PostMapping(value = "/")
    public ResponseEntity<Route> agregar(@RequestBody Route route){
        
        Route obj = routeService.save(route);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Route> eliminar(@PathVariable Integer id){
        Route obj = routeService.findById(id);
        if(obj != null)
            routeService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Route> editar(@RequestBody Route route){
        Route obj = routeService.findById(route.getIdRoute());
        if(obj != null){
            obj.setDepTime(route.getDepTime());
            obj.setArrTime(route.getArrTime());
            obj.setFlightTime(route.getFlightTime());
            obj.setCityOrg(route.getCityOrg());
            obj.setAirportOrg(route.getAirportOrg());
            obj.setAirportDest(route.getAirportDest());
            obj.setCityDest(route.getCityDest());
            
            routeService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Route> consultarTodo(){
        return routeService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Route consultarPorId(@PathVariable Integer id){
        return routeService.findById(id);
    }
}
