/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;



/**
 *
 * @author pc
 */
import com.example.enchere.dao.*;
@TableName(table = "Produit",view="9")   
public class Produit extends AccessBase{
    @Attribute(attrName = "idProduit", attrType = "", idPrimaryKey = "yes")
    private Integer idProduit;
   @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    private String nom;
    @Attribute(attrName = "idCategory", attrType = "", idPrimaryKey = "")
    private Integer idCategory;

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
