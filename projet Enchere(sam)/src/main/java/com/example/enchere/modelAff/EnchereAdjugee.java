/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.modelAff;

import com.example.enchere.dao.*;
import java.sql.Date;
@TableName(table = "Enchere",view="vw_EncherereAdjugee")   
public class EnchereAdjugee extends AccessBase{
    @Attribute(attrName = "idenchere", attrType = "", idPrimaryKey = "yes")
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
    @Attribute(attrName = "idproposition", attrType = "", idPrimaryKey = "")
    private Integer idProposition;
    @Attribute(attrName = "clientidclientprop", attrType = "", idPrimaryKey = "")
    private Integer clientidclientprop;
    @Attribute(attrName = "valeur", attrType = "", idPrimaryKey = "")
    private Integer prixVente;
    @Attribute(attrName = "idcommission", attrType = "", idPrimaryKey = "")
    private Integer idCommission;
    @Attribute(attrName = "idproposition", attrType = "", idPrimaryKey = "")
    private Float pourcentage;

    public Integer getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(Integer idProposition) {
        this.idProposition = idProposition;
    }

    public Integer getClientidclientprop() {
        return clientidclientprop;
    }

    public void setClientidclientprop(Integer clientidclientprop) {
        this.clientidclientprop = clientidclientprop;
    }

    public Integer getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Integer prixVente) {
        this.prixVente = prixVente;
    }

    public Integer getIdCommission() {
        return idCommission;
    }

    public void setIdCommission(Integer idCommission) {
        this.idCommission = idCommission;
    }

    public Float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Float pourcentage) {
        this.pourcentage = pourcentage;
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