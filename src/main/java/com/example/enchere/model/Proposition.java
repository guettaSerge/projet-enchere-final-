/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;
import java.util.Date;



/**
 *
 * @author pc
 */
import com.example.enchere.dao.*;
@TableName(table = "Proposition",view="9")   
public class Proposition extends AccessBase{
    @Attribute(attrName = "idproposition", attrType = "", idPrimaryKey = "yes")
    private Integer idProposition;
   @Attribute(attrName = "valeur", attrType = "", idPrimaryKey = "")
    private Float valeur;
    @Attribute(attrName = "dateProposition", attrType = "", idPrimaryKey = "")
    private Date dateProposition;
    @Attribute(attrName = "idEnchere", attrType = "", idPrimaryKey = "")
    private Integer idEnchere;
    @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
    private Integer idClient;

    public Integer getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(Integer idProposition) {
        this.idProposition = idProposition;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public Date getDateProposition() {
        return dateProposition;
    }

    public void setDateProposition(Date dateProposition) {
        this.dateProposition = dateProposition;
    }

    public Integer getIdEnchere() {
        return idEnchere;
    }

    public void setIdEnchere(Integer idEnchere) {
        this.idEnchere = idEnchere;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
}
