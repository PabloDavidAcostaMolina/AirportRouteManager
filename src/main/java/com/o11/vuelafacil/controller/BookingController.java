/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.controller;

import com.o11.vuelafacil.models.Booking;
import com.o11.vuelafacil.services.BookingService;
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
@RequestMapping("/booking")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;
    
    @PostMapping(value = "/")
    public ResponseEntity<Booking> agregar(@RequestBody Booking booking){
        
        Booking obj = bookingService.save(booking);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Booking> eliminar(@PathVariable Integer id){
        Booking obj = bookingService.findById(id);
        if(obj != null)
            bookingService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Booking> editar(@RequestBody Booking booking){
        Booking obj = bookingService.findById(booking.getIdBooking());
        if(obj != null){
            obj.setBookingDate(booking.getBookingDate());
            obj.setSeatCat(booking.getSeatCat());
            obj.setUser(booking.getUser());
            obj.setStatus(booking.getStatus());
            obj.setFlight(booking.getFlight());
            bookingService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Booking> consultarTodo(){
        return bookingService.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Booking consultarPorId(@PathVariable Integer id){
        return bookingService.findById(id);
    }
}
