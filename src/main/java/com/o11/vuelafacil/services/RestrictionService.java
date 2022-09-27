/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.o11.vuelafacil.services;

import com.o11.vuelafacil.models.Restriction;
import java.util.List;

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
public interface RestrictionService {
    
    public Restriction save(Restriction restriction);
    public void delete(Integer id);
    public Restriction findById(Integer id);
    public List<Restriction> findAll();
}
