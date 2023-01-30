/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.enchere.modelAff;

import com.example.enchere.dao.AccessBase;
import com.example.enchere.dao.Attribute;
import com.example.enchere.dao.TableName;

/**
 *
 * @author P14A-Serge
 */
@TableName(table = "_",view="vw_maxPropositionValue") 
public class ValeurEnchereMax extends AccessBase{
    @Attribute(attrName = "idenchere", attrType = "", idPrimaryKey = "")
    private Integer idEnchere;
    @Attribute(attrName = "Valeur", attrType = "", idPrimaryKey = "")
    private Double valeur;

    public Integer getIdEnchere() {
        return idEnchere;
    }

    public void setIdEnchere(Integer idEnchere) {
        this.idEnchere = idEnchere;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }
    
}
