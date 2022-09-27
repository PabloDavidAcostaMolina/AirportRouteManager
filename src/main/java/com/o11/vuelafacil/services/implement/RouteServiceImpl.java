/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.RouteDao;
import com.o11.vuelafacil.models.Route;
import com.o11.vuelafacil.services.RouteService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class RouteServiceImpl implements RouteService{
    
    @Autowired
    private RouteDao  routeDao;
    
    @Override
    @Transactional(readOnly = false)
    public Route save(Route route){
        return routeDao.save(route);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        routeDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Route findById(Integer id){
        return routeDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Route> findAll(){
        return (List<Route>) routeDao.findAll();
    }
}
