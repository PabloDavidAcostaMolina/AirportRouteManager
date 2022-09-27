/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.o11.vuelafacil.services;

import com.o11.vuelafacil.models.Route;
import java.util.List;

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
public interface RouteService {
    
    public Route save(Route route);
    public void delete(Integer id);
    public Route findById(Integer id);
    public List<Route> findAll();
}
