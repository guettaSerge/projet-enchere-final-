/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.enchere.model;

import com.example.enchere.dao.Attribute;
import com.example.enchere.dao.TableName;


/**
 *
 * @author pc
 */
@TableName(table = "Commission",view="9")
public class Commission {
    @Attribute(attrName = "idCommission", attrType = "", idPrimaryKey = "yes")
    private Integer idCommission;
    
    @Attribute(attrName = "pourcentage", attrType = "", idPrimaryKey = "")
    private Float pourcentage;

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
    
    
}
