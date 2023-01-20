/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.modelAff;

/**
 *
 * @author P14A-Serge
 */
import com.example.enchere.dao.*;
import java.sql.Date;
@TableName(table = "Enchere",view="vw_EnchereWithStatut")   
public class Encheres extends AccessBase{
    @Attribute(attrName = "", attrType = "", idPrimaryKey = "yes")
    private Integer idEnchere;
   @Attribute(attrName = "debut", attrType = "", idPrimaryKey = "")
    private Date debut;
   @Attribute(attrName = "fin", attrType = "", idPrimaryKey = "")
    private Date fin;
   @Attribute(attrName = "prixDepart", attrType = "", idPrimaryKey = "")
    private Float prixDepart;
    @Attribute(attrName = "idProduit", attrType = "", idPrimaryKey = "")
    private Integer idProduit;
    @Attribute(attrName = "idClient", attrType = "", idPrimaryKey = "")
    private Integer idClient;
    @Attribute(attrName = "statut", attrType = "", idPrimaryKey = "")
    private Integer statut;

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }
    
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

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
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