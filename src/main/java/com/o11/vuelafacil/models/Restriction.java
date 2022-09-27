/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.o11.vuelafacil.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author The fear of blood tends to create fear for the flesh
 */
@Entity
@Table(name = "restriction")
public class Restriction implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrestriction")
    private Integer idRestriction;
    
    @Column(name = "restrictiondesc")
    private String restrictionDesc;

    public Integer getIdRestriction() {
        return idRestriction;
    }

    public void setIdRestriction(Integer idRestriction) {
        this.idRestriction = idRestriction;
    }

    public String getRestrictionDesc() {
        return restrictionDesc;
    }

    public void setRestrictionDesc(String restrictionDesc) {
        this.restrictionDesc = restrictionDesc;
    }
    
    
}
