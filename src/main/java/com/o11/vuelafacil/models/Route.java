/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Entity
@Table(name = "route")
public class Route implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idroute")
    private Integer idRoute;
    
    @ManyToOne
    @JoinColumn(name="idcityorg")
    private City cityOrg;
    
    @ManyToOne
    @JoinColumn(name="idairportorg")
    private Airport airportOrg;
    
    @ManyToOne
    @JoinColumn(name="idairportdest")
    private Airport airportDest;
    
    @ManyToOne
    @JoinColumn(name="idcitydest")
    private City cityDest;
    
    @Column(name = "deptime")
    private Date depTime;//cambiar a tipo mas adecuado
    
    @Column(name = "arrtime")
    private Date arrTime;//cambiar a tipo mas adecuado
    
    @Column(name = "flighttime")
    private String flightTime;

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public City getCityOrg() {
        return cityOrg;
    }

    public void setCityOrg(City cityOrg) {
        this.cityOrg = cityOrg;
    }

    public Airport getAirportOrg() {
        return airportOrg;
    }

    public void setAirportOrg(Airport airportOrg) {
        this.airportOrg = airportOrg;
    }

    public Airport getAirportDest() {
        return airportDest;
    }

    public void setAirportDest(Airport airportDest) {
        this.airportDest = airportDest;
    }

    public City getCityDest() {
        return cityDest;
    }

    public void setCityDest(City cityDest) {
        this.cityDest = cityDest;
    }

    public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }

    public Date getArrTime() {
        return arrTime;
    }

    public void setArrTime(Date arrTime) {
        this.arrTime = arrTime;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }
    
    
    
}
    
    