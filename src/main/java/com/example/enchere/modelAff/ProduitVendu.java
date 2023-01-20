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
@TableName(table = "Produit",view="vw_produitVenduAff")   
public class ProduitVendu extends AccessBase{
    @Attribute(attrName = "idProduit", attrType = "", idPrimaryKey = "yes")
    private Integer idProduit;
   @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    private String nom;
    @Attribute(attrName = "categoryidcategory", attrType = "", idPrimaryKey = "")
    private Integer idCategory;
    @Attribute(attrName = "nombreproduit", attrType = "", idPrimaryKey = "")
    private Integer nombreVendu;
    @Attribute(attrName = "months", attrType = "", idPrimaryKey = "")
    private Integer month;
    @Attribute(attrName = "years", attrType = "", idPrimaryKey = "")
    private Integer years;

    public Integer getNombreVendu() {
        return nombreVendu;
    }

    public void setNombreVendu(Integer nombreVendu) {
        this.nombreVendu = nombreVendu;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
   
    
    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }
}