/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.controller;

import com.o11.vuelafacil.models.Flight;
import com.o11.vuelafacil.services.FlightService;
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
@RequestMapping("/flight")
public class FlightController {
    
    @Autowired
    private FlightService flightService;
    
    @PostMapping(value = "/")
    public ResponseEntity<Flight> agregar(@RequestBody Flight flight){
        
        Flight obj = flightService.save(flight);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Flight> eliminar(@PathVariable Integer id){
        Flight obj = flightService.findById(id);
        if(obj != null)
            flightService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Flight> editar(@RequestBody Flight flight){
        Flight obj = flightService.findById(flight.getIdFlight());
        if(obj != null){
            obj.setFlightDate(flight.getFlightDate());
            obj.setPaxCapacity(flight.getPaxCapacity());
            obj.setAvlSeat(flight.getAvlSeat());
            obj.setRoute(flight.getRoute());
            flightService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Flight> consultarTodo(){
        return flightService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Flight consultarPorId(@PathVariable Integer id){
        return flightService.findById(id);
    }
}
