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
@TableName(table = "MouvementEntree",view="9")   
public class MouvementEntree extends AccessBase{
    @Attribute(attrName = "idMouvementEntree", attrType = "", idPrimaryKey = "")
    private Integer idMouvementEntree;
   @Attribute(attrName = "valeur", attrType = "", idPrimaryKey = "")
    private Float valeur;
    @Attribute(attrName = "date", attrType = "", idPrimaryKey = "")
    private Date date;
   @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
    private Integer idClient;

    public Integer getIdMouvementEntree() {
        return idMouvementEntree;
    }

    public void setIdMouvementEntree(Integer idMouvementEntree) {
        this.idMouvementEntree = idMouvementEntree;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    Integer idAdmin;
}
