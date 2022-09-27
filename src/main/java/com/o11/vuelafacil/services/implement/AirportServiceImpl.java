/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.AirportDao;
import com.o11.vuelafacil.models.Airport;
import com.o11.vuelafacil.services.AirportService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class AirportServiceImpl implements AirportService{
    
    @Autowired
    private AirportDao airportDao;
    
    @Override
    @Transactional(readOnly = false)
    public Airport save(Airport airport){
        return airportDao.save(airport);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        airportDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Airport findById(Integer id){
        return airportDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Airport> findAll(){
        return (List<Airport>) airportDao.findAll();
    }
}
