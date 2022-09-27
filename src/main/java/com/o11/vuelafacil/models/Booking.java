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
@Table(name = "booking")
public class Booking implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbooking")
    private Integer idBooking;
    
    @ManyToOne
    @JoinColumn(name="iduser")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="idstatus")
    private Status status;
    
    @ManyToOne
    @JoinColumn(name="idflight")
    private Flight flight;
        
    @Column(name = "bookingdate")
    private Date bookingDate;
    
    @Column(name = "seatcat")
    private Integer seatCat;

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getSeatCat() {
        return seatCat;
    }

    public void setSeatCat(Integer seatCat) {
        this.seatCat = seatCat;
    }

    

    
}
