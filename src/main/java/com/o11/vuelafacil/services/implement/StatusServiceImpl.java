/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.StatusDao;
import com.o11.vuelafacil.models.Status;
import com.o11.vuelafacil.services.StatusService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class StatusServiceImpl implements StatusService{
    
    @Autowired
    private StatusDao  statusDao;
    
    @Override
    @Transactional(readOnly = false)
    public Status save(Status status){
        return statusDao.save(status);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        statusDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Status findById(Integer id){
        return statusDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Status> findAll(){
        return (List<Status>) statusDao.findAll();
    }
}
