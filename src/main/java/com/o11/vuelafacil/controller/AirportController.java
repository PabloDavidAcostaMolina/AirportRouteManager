/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.controller;

import com.o11.vuelafacil.models.Airport;
import com.o11.vuelafacil.services.AirportService;
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
@RequestMapping("/airport")
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    @PostMapping(value = "/")
    public ResponseEntity<Airport> agregar(@RequestBody Airport airport){
        
        Airport obj = airportService.save(airport);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Airport> eliminar(@PathVariable Integer id){
        Airport obj = airportService.findById(id);
        if(obj != null)
            airportService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Airport> editar(@RequestBody Airport airport){
        Airport obj = airportService.findById(airport.getIdAirport());
        if(obj != null){
            obj.setAirport(airport.getAirport());
            obj.setCity(airport.getCity());
            airportService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Airport> consultarTodo(){
        return airportService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Airport consultarPorId(@PathVariable Integer id){
        return airportService.findById(id);
    }
}
