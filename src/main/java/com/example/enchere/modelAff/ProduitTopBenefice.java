/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.modelAff;


import com.example.enchere.dao.*;
@TableName(table = "Produit",view="vw_topBeneficeProduitAff")   
public class ProduitTopBenefice extends AccessBase{
    @Attribute(attrName = "idProduit", attrType = "", idPrimaryKey = "yes")
    private Integer idProduit;
   @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    private String nom;
    @Attribute(attrName = "categoryidcategory", attrType = "", idPrimaryKey = "")
    private Integer idCategory;
    @Attribute(attrName = "benefice", attrType = "", idPrimaryKey = "")
    private Double benefice;
    @Attribute(attrName = "months", attrType = "", idPrimaryKey = "")
    private Integer month;
    @Attribute(attrName = "years", attrType = "", idPrimaryKey = "")
    private Integer years;

    public Double getBenefice() {
        return benefice;
    }

    public void setBenefice(Double benefice) {
        this.benefice = benefice;
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