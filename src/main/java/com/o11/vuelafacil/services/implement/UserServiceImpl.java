/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.UserDao;
import com.o11.vuelafacil.models.User;
import com.o11.vuelafacil.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao  userDao;
    
    @Override
    @Transactional(readOnly = false)
    public User save(User user){
        return userDao.save(user);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        userDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id){
        return userDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll(){
        return (List<User>) userDao.findAll();
    }
}
