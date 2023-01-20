/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;

import com.example.enchere.dao.AccessBase;
import com.example.enchere.dao.Attribute;
import com.example.enchere.dao.TableName;



/**
 *
 * @author pc
 */
@TableName(table = "Category",view="9")
public class Category extends AccessBase{
    @Attribute(attrName = "idCategory", attrType = "", idPrimaryKey = "yes")
    private Integer idCategory;
    @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    private String nom;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
