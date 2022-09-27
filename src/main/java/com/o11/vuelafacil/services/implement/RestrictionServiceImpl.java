/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.RestrictionDao;
import com.o11.vuelafacil.models.Restriction;
import com.o11.vuelafacil.services.RestrictionService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class RestrictionServiceImpl implements RestrictionService{
    
    @Autowired
    private RestrictionDao  restrictionDao;
    
    @Override
    @Transactional(readOnly = false)
    public Restriction save(Restriction restriction){
        return restrictionDao.save(restriction);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        restrictionDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Restriction findById(Integer id){
        return restrictionDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Restriction> findAll(){
        return (List<Restriction>) restrictionDao.findAll();
    }
}
