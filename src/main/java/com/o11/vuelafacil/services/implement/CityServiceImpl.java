/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.CityDao;
import com.o11.vuelafacil.models.City;
import com.o11.vuelafacil.services.CityService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class CityServiceImpl implements CityService{
    
    @Autowired
    private CityDao  cityDao;
    
    @Override
    @Transactional(readOnly = false)
    public City save(City city){
        return cityDao.save(city);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        cityDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public City findById(Integer id){
        return cityDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<City> findAll(){
        return (List<City>) cityDao.findAll();
    }
    
}
