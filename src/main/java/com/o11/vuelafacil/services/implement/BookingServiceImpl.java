/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.services.implement;

import com.o11.vuelafacil.dao.BookingDao;
import com.o11.vuelafacil.models.Booking;
import com.o11.vuelafacil.services.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Service
public class BookingServiceImpl implements BookingService{
    
    @Autowired
    private BookingDao bookingDao;
    
    @Override
    @Transactional(readOnly = false)
    public Booking save(Booking booking){
        return bookingDao.save(booking);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id){
        bookingDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Booking findById(Integer id){
        return bookingDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll(){
        return (List<Booking>) bookingDao.findAll();
    }
}
