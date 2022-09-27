/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.o11.vuelafacil.dao;

import com.o11.vuelafacil.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
public interface UserDao extends CrudRepository<User, Integer>{
    
}
