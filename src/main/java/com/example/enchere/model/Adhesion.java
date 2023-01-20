/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.model;

import com.example.enchere.dao.*;

/**
 *
 * @author P14A-Serge
 */
@TableName(table = "adhesion",view="9")
public class Adhesion extends AccessBase{
    @Attribute(attrName = "id", attrType = "", idPrimaryKey = "yes")
    private Integer id;
    @Attribute(attrName = "idPersonne", attrType = "", idPrimaryKey = "")
    private Integer idPersonne;
    @Attribute(attrName = "idProgramme", attrType = "", idPrimaryKey = "")
    private Integer idProgramme;
    @Attribute(attrName = "idPromotion", attrType = "", idPrimaryKey = "")
    private Integer idPromotion;
    @Attribute(attrName = "statut", attrType = "", idPrimaryKey = "")
    private Integer statut;

    public Integer getIdProgramme() {
        return idProgramme;
    }

    public void setIdProgramme(Integer idProgramme) {
        this.idProgramme = idProgramme;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }
    
}
