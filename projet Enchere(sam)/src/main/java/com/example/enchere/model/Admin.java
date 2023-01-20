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
@TableName(table = "Admin",view="9")
public class Admin extends AccessBase {
   @Attribute(attrName = "idAdmin", attrType = "", idPrimaryKey = "yes")
    private Integer idAdmin;
    @Attribute(attrName = "nom", attrType = "", idPrimaryKey = "")
    private String nom;
    @Attribute(attrName = "email", attrType = "", idPrimaryKey = "")
    private String email;
    @Attribute(attrName = "passe", attrType = "", idPrimaryKey = "")
    String passe;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }
}
