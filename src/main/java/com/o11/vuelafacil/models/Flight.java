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

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Entity
@Table(name = "flight")
public class Flight implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflight")
    private Integer idFlight;
           
    @ManyToOne
    @JoinColumn(name="idroute")
    private Route route;
    
    @Column(name = "flightdate")
    private Date flightDate;//cambiar a tipo mas adecuado
    
    @Column(name = "paxcapacity")
    private Integer paxCapacity;
    
    @Column(name = "avlseat")
    private Integer avlSeat;

    public Integer getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Integer idFlight) {
        this.idFlight = idFlight;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Integer getPaxCapacity() {
        return paxCapacity;
    }

    public void setPaxCapacity(Integer paxCapacity) {
        this.paxCapacity = paxCapacity;
    }

    public Integer getAvlSeat() {
        return avlSeat;
    }

    public void setAvlSeat(Integer avlSeat) {
        this.avlSeat = avlSeat;
    }
    
    
}
