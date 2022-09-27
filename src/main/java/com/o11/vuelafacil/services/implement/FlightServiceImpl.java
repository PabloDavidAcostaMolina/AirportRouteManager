/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.FlightDao;
import com.o11.vuelafacil.models.Flight;
import com.o11.vuelafacil.services.FlightService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class FlightServiceImpl implements FlightService{
    
    @Autowired
    private FlightDao  flightDao;
    
    @Override
    @Transactional(readOnly = false)
    public Flight save(Flight flight){
        return flightDao.save(flight);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        flightDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Flight findById(Integer id){
        return flightDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Flight> findAll(){
        return (List<Flight>) flightDao.findAll();
    }
}
