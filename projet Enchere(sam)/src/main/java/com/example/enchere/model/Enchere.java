/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;

import java.sql.Time;
import java.util.Date;



import com.example.enchere.dao.*;
@TableName(table = "Enchere",view="9")   
public class Enchere extends AccessBase{
    @Attribute(attrName = "", attrType = "", idPrimaryKey = "yes")
    private Integer idEnchere;
   @Attribute(attrName = "debut", attrType = "", idPrimaryKey = "")
    private Date debut;
   @Attribute(attrName = "duree", attrType = "", idPrimaryKey = "")
    private Time fin;
   @Attribute(attrName = "prixDepart", attrType = "", idPrimaryKey = "")
    private Float prixDepart;
    @Attribute(attrName = "idProduit", attrType = "", idPrimaryKey = "")
    private Integer idProduit;
    @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
    private Integer idClient;

    public Integer getIdEnchere() {
        return idEnchere;
    }

    public void setIdEnchere(Integer idEnchere) {
        this.idEnchere = idEnchere;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Time getFin() {
        return fin;
    }

    public void setFin(Time fin) {
        this.fin = fin;
    }

    public Float getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Float prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
}
